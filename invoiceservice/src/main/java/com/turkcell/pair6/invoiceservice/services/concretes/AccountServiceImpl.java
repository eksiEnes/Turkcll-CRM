package com.turkcell.pair6.invoiceservice.services.concretes;

import com.turkcell.pair6.invoiceservice.clients.CustomerServiceClient;
import com.turkcell.pair6.invoiceservice.clients.ProductServiceClient;
import com.turkcell.pair6.invoiceservice.entities.Account;
import com.turkcell.pair6.invoiceservice.repositories.AccountRepository;
import com.turkcell.pair6.invoiceservice.services.abstracts.AccountService;
import com.turkcell.pair6.invoiceservice.services.dtos.requests.AddAddressRequest;
import com.turkcell.pair6.invoiceservice.services.dtos.requests.AddBillingRequest;
import com.turkcell.pair6.invoiceservice.services.dtos.requests.UpdateAccountRequest;
import com.turkcell.pair6.invoiceservice.services.dtos.requests.UpdateAddressRequest;
import com.turkcell.pair6.invoiceservice.services.dtos.responses.AccountResponse;
import com.turkcell.pair6.invoiceservice.services.mappers.AccountMapper;
import com.turkcell.pair6.invoiceservice.services.mappers.AddressMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final CustomerServiceClient customerServiceClient;
    private final ProductServiceClient productServiceClient;

    @Override
    public List<AccountResponse> getAll(Pageable pageable) {
        Page<Account> accountPage = accountRepository.findAll(pageable);
        return accountPage.map(AccountMapper.INSTANCE::accountResponseFromAccount).getContent();
    }

    @Override
    public void add(AddBillingRequest request) {
        Account account = AccountMapper.INSTANCE.accountFromAddRequest(request);
        AddAddressRequest addressRequest = AddressMapper.INSTANCE.addAddress(request.getAddress());
        addressRequest.setCustomerId(request.getCustomerId());
        account.setAddressId(customerServiceClient.add(addressRequest));
        account.setType("billing");
        accountRepository.save(account);
    }

    @Override
    public String delete(int id) {
        if (!productServiceClient.hasAccountProduct(id)){
            accountRepository.deleteById(id);
            return "Customer account deleted successfully";
        }
        else
            return "This billing account cannot be deleted because there is a product linked to this billing account";
    }

    @Override
    public void update(UpdateAccountRequest request) {
        Optional<Account> optionalAccount = accountRepository.findById(request.getId());
        Account account = optionalAccount.orElse(null);

        Account updatedAccount = AccountMapper.INSTANCE.accountFromUpdateRequest(request , account);
        UpdateAddressRequest addressRequest = AddressMapper.INSTANCE.updateAddress(request.getAddress());
        addressRequest.setId(account.getAddressId());
        customerServiceClient.update(addressRequest);
        accountRepository.save(updatedAccount);
    }
}

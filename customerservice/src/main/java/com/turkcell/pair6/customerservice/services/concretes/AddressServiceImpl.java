package com.turkcell.pair6.customerservice.services.concretes;

import com.turkcell.pair6.customerservice.entities.Address;
import com.turkcell.pair6.customerservice.repositories.AddressRepository;
import com.turkcell.pair6.customerservice.services.abstracts.AddressService;
import com.turkcell.pair6.customerservice.services.dtos.requests.AddAddressRequest;
import com.turkcell.pair6.customerservice.services.mappers.AddressMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public void add(AddAddressRequest request) {
        Address address = AddressMapper.INSTANCE.addressFromAddRequest(request);
        addressRepository.save(address);
    }
}

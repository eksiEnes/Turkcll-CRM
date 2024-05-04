package com.turkcell.pair6.invoiceservice.services.rules;

import com.turkcell.core.exceptions.types.BusinessException;
import com.turkcell.core.service.abstracts.MessageService;
import com.turkcell.core.service.constants.Messages;
import com.turkcell.pair6.invoiceservice.clients.ProductServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Component
public class AccountBusinessRules {
    private final ProductServiceClient productServiceClient;
    private final MessageService messageService;

    public void hasAccountProduct(int id) {
        if (productServiceClient.hasAccountProduct(id)) {
            throw new BusinessException(messageService.getMessage(Messages.BusinessErrors.ACCOUNT_HAS_PRODUCT));
        }
    }
}

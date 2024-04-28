package com.turkcell.pair6.invoiceservice.services.dtos.requests;

import com.turkcell.pair6.customerservice.services.dtos.requests.AddAddressRequest;
import com.turkcell.pair6.invoiceservice.entities.Address;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddBillingRequest {
    private String name;

    private String description;

    private AddressRequest address;

    @Min(1)
    private int customerId;
}

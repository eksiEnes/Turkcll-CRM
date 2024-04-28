package com.turkcell.pair6.customerservice.services.dtos.requests;

import com.turkcell.pair6.customerservice.core.service.constants.Messages;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddContactRequest {
    @NotBlank(message = Messages.ValidationErrors.FIELD_NOT_BLANK)
    private String email;

    private String homePhone;

    @NotBlank(message = Messages.ValidationErrors.FIELD_NOT_BLANK)
    private String mobilePhone;

    private String fax;

    @Min(1)
    private int customerId;
}

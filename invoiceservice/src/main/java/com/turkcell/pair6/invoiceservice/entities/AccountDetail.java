package com.turkcell.pair6.invoiceservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetail {
    private int productId;
    private String productName;
    private String companyName;
    private String companyId;
    private String action;
}

package com.turkcell.pair6.productservice.services.dtos.requests;

import com.turkcell.pair6.productservice.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailsRequest {


    private String offerName;

    private String offerId;

    private String specId;

}

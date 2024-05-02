package com.turkcell.pair6.productservice.services.dtos.requests;

import com.turkcell.pair6.productservice.entities.ProductDetails;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {


    private String productNo;

    private String name;

    private String campaignName;

    private String campaignId;

    private String action;

    private ProductDetailsRequest productDetailsRequest;
}

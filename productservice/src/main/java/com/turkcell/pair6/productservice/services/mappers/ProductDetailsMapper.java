package com.turkcell.pair6.productservice.services.mappers;

import com.turkcell.pair6.productservice.entities.ProductDetails;
import com.turkcell.pair6.productservice.services.dtos.requests.ProductDetailsDto;
import com.turkcell.pair6.productservice.services.dtos.requests.ProductDetailsRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductDetailsMapper {
    ProductDetailsMapper INSTANCE = Mappers.getMapper(ProductDetailsMapper.class);

    @Mapping(source="productId", target="product.id")
    ProductDetails productDetailsFromAddRequest(ProductDetailsDto request);

    ProductDetailsDto dtoFromRequest(ProductDetailsRequest request);

    ProductDetails productFromUpdateRequest(ProductDetails request, @MappingTarget ProductDetails productDetails);
}

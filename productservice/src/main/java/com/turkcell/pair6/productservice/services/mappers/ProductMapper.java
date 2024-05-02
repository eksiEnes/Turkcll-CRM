package com.turkcell.pair6.productservice.services.mappers;

import com.turkcell.pair6.productservice.entities.Product;
import com.turkcell.pair6.productservice.services.dtos.requests.ProductRequest;
import com.turkcell.pair6.productservice.services.dtos.requests.ProductUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {


    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);


    Product productFromAddRequest(ProductRequest request);



    Product productFromUpdateRequest(ProductUpdateRequest request, @MappingTarget Product product);
}

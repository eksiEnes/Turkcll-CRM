package com.turkcell.pair6.productservice.services.abstracts;

import com.turkcell.pair6.productservice.entities.ProductDetails;
import com.turkcell.pair6.productservice.services.dtos.requests.ProductDetailsDto;
import com.turkcell.pair6.productservice.services.dtos.requests.ProductDetailsRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductDetailsService {
    List<ProductDetails> getAll(Pageable pageable);

    ProductDetails add(ProductDetailsDto product);

    void delete(int id);

    void update(ProductDetails product);
}

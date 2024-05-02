package com.turkcell.pair6.productservice.services.abstracts;

import com.turkcell.pair6.productservice.entities.Product;
import com.turkcell.pair6.productservice.services.dtos.requests.ProductRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> getAll(Pageable pageable);

    void add(ProductRequest product);

    void delete(int id);

    void update(ProductRequest product);
}

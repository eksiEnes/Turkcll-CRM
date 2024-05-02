package com.turkcell.pair6.productservice.services.concretes;

import com.turkcell.pair6.productservice.entities.Product;
import com.turkcell.pair6.productservice.repositories.ProductRepository;
import com.turkcell.pair6.productservice.services.abstracts.ProductService;
import com.turkcell.pair6.productservice.services.dtos.requests.ProductRequest;
import com.turkcell.pair6.productservice.services.mappers.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAll(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return products.getContent();

    }

    @Override
    public void add(ProductRequest productRequest) {

        Product product = ProductMapper.INSTANCE.productFromAddRequest(productRequest);
        productRepository.save(product);

    }

    @Override
    public void delete(int id) {

        productRepository.deleteById(id);
    }

    @Override
    public void update(ProductRequest productRequest) {


        Product product = productRepository.findByProductNo(productRequest.getProductNo()).orElse(null);
        Product updatedProduct = ProductMapper.INSTANCE.productFromUpdateRequest(productRequest,product);
        productRepository.save(updatedProduct);


    }
}

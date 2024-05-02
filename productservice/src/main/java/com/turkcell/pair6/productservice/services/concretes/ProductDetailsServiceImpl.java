package com.turkcell.pair6.productservice.services.concretes;

import com.turkcell.pair6.productservice.entities.ProductDetails;
import com.turkcell.pair6.productservice.repositories.ProductDetailsRepository;
import com.turkcell.pair6.productservice.services.abstracts.ProductDetailsService;
import com.turkcell.pair6.productservice.services.dtos.requests.ProductDetailsDto;
import com.turkcell.pair6.productservice.services.dtos.requests.ProductDetailsRequest;
import com.turkcell.pair6.productservice.services.mappers.ProductDetailsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductDetailsServiceImpl implements ProductDetailsService {
    private final ProductDetailsRepository productDetailsRepository;

    @Override
    public List<ProductDetails> getAll(Pageable pageable) {
        return productDetailsRepository.findAll(pageable).getContent();
    }

    @Override
    public ProductDetails add(ProductDetailsDto request) {
        ProductDetails productDetails = ProductDetailsMapper.INSTANCE.productDetailsFromAddRequest(request);
        productDetailsRepository.save(productDetails);
        return productDetails;
    }

    @Override
    public void delete(int id) {
        productDetailsRepository.deleteById(id);
    }

    @Override
    public void update(ProductDetails product) {
        ProductDetails productDetails = productDetailsRepository.findById(product.getId()).orElse(null);
        ProductDetails updatedProduct = ProductDetailsMapper.INSTANCE.productFromUpdateRequest(product, productDetails);
        productDetailsRepository.save(updatedProduct);

    }
}

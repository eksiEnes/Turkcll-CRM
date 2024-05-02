package com.turkcell.pair6.productservice.services.concretes;

import com.turkcell.pair6.productservice.entities.Product;
import com.turkcell.pair6.productservice.entities.ProductDetails;
import com.turkcell.pair6.productservice.repositories.ProductRepository;
import com.turkcell.pair6.productservice.services.abstracts.ProductDetailsService;
import com.turkcell.pair6.productservice.services.abstracts.ProductService;
import com.turkcell.pair6.productservice.services.dtos.requests.ProductDetailsDto;
import com.turkcell.pair6.productservice.services.dtos.requests.ProductRequest;
import com.turkcell.pair6.productservice.services.dtos.requests.ProductUpdateRequest;
import com.turkcell.pair6.productservice.services.mappers.ProductDetailsMapper;
import com.turkcell.pair6.productservice.services.mappers.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductDetailsService productDetailsService;

    @Override
    public List<Product> getAll(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return products.getContent();

    }

    @Override
    public void add(ProductRequest productRequest) {

        Product product = ProductMapper.INSTANCE.productFromAddRequest(productRequest);
        productRepository.save(product);
        ProductDetailsDto detailsDto = ProductDetailsMapper.INSTANCE.dtoFromRequest(productRequest.getProductDetailsRequest());
        detailsDto.setProductId(product.getId());
        product.setProductDetails(productDetailsService.add(detailsDto));
        productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        Product product = productRepository.findById(id).orElse(null);
        productDetailsService.delete(product.getProductDetails().getId());
        productRepository.deleteById(id);
    }

    @Override
    public void update(ProductUpdateRequest productRequest) {


        Product product = productRepository.findById(productRequest.getId()).orElse(null);
        Product updatedProduct = ProductMapper.INSTANCE.productFromUpdateRequest(productRequest,product);
        ProductDetailsDto dto = ProductDetailsMapper.INSTANCE.dtoFromRequest(productRequest.getProductDetailsRequest());
        ProductDetails productDetails = ProductDetailsMapper.INSTANCE.productDetailsFromAddRequest(dto);
        productDetailsService.update(productDetails);
        updatedProduct.setProductDetails(productDetails);
        productRepository.save(updatedProduct);
    }
}

package com.w4you.productservice.service;

import com.w4you.productservice.dto.ProductRequestDto;
import com.w4you.productservice.dto.ProductResponseDto;
import com.w4you.productservice.model.Product;
import com.w4you.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public String createProduct(final ProductRequestDto productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved ", product.getId());
        return product.getId();
    }

    public Page<ProductResponseDto> findAll(Pageable page) {
        return productRepository.findAll(page).map(ProductResponseDto::new);
    }
}

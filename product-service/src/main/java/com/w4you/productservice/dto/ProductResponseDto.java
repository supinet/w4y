package com.w4you.productservice.dto;

import com.w4you.productservice.model.Product;

import java.math.BigDecimal;

public record ProductResponseDto(
    String id,
    String name,
    String description,
    BigDecimal price
) {
    public ProductResponseDto(Product product) {
        this(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }
}

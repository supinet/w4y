package com.w4you.orderservice.dto;

import java.math.BigDecimal;

public record ItemDto(
        Long id,
        String sku,
        BigDecimal price,
        Integer quantity
) {
}

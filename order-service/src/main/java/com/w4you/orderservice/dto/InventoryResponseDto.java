package com.w4you.orderservice.dto;

import lombok.Builder;

@Builder
public record InventoryResponseDto(
        String sku,
        boolean isInStock
) {
}

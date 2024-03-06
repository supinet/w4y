package com.w4you.inventoryservice.dto;

import lombok.Builder;

@Builder
public record InventoryResponseDto(
        String sku,
        boolean isInStock
) {
}

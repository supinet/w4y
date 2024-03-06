package com.w4you.orderservice.dto;

import java.util.Set;

public record OrderRequestDto (
        Set<ItemDto> items
) {
}

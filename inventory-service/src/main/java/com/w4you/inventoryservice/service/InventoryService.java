package com.w4you.inventoryservice.service;

import com.w4you.inventoryservice.dto.InventoryResponseDto;
import com.w4you.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public Set<InventoryResponseDto> isInStock(final Set<String> skus) {
        return inventoryRepository.findBySkuIn(skus).stream()
                .map(inventory ->
                    InventoryResponseDto.builder()
                        .sku(inventory.getSku())
                        .isInStock(inventory.getQuantity() > 0)
                        .build()
                ).collect(Collectors.toSet());
    }
}

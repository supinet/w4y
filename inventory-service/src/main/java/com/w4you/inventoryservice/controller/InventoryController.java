package com.w4you.inventoryservice.controller;

import com.w4you.inventoryservice.dto.InventoryResponseDto;
import com.w4you.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping( "api/inventory")
@RequiredArgsConstructor
@Slf4j
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<InventoryResponseDto> isInStock(@RequestParam final Set<String> skus) {
        log.info("Received inventory check request for skus: {}", skus);
        return inventoryService.isInStock(skus);
    }

}

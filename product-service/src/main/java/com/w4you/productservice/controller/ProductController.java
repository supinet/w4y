package com.w4you.productservice.controller;

import com.w4you.productservice.dto.ProductRequestDto;
import com.w4you.productservice.dto.ProductResponseDto;
import com.w4you.productservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @PostMapping
    @Transactional
    public ResponseEntity createProduct(@RequestBody @Valid final ProductRequestDto productRequest, UriComponentsBuilder uriBuilder) {
        final String id = productService.createProduct(productRequest);
        var uri = uriBuilder.path("/products/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).body(id);
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponseDto>> list(@PageableDefault(sort = {"name"}) Pageable pagination) {
        return ResponseEntity.ok(productService.findAll(pagination));
    }
}

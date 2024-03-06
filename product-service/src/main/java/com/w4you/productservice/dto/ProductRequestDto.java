package com.w4you.productservice.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

public record ProductRequestDto(
        @NotBlank
        String name,

        @NotBlank
        String description,

        @Range(min = 1)
        BigDecimal price
) {}

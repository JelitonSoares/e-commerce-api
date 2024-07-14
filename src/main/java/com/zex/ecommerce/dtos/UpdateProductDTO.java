package com.zex.ecommerce.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record UpdateProductDTO(@NotNull UUID id,

                               String name,

                               String description,

                               BigDecimal value,

                               Integer stock) {
}

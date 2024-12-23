package com.zex.ecommerce.domain.product;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record UpdateProductDTO(@NotNull String id,

                               String name,

                               String description,

                               BigDecimal value,

                               Integer stock) {
}

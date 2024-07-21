package com.zex.ecommerce.dtos.product;

import com.zex.ecommerce.models.product.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateProductDTO(
                               @NotBlank
                         String name,
                               @NotBlank
                         String description,
                               @NotNull
                         BigDecimal value,
                               @NotNull
                         Integer stock,
                               @NotNull
                         Category category) {

}

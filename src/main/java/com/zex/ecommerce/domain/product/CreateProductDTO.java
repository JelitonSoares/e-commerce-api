package com.zex.ecommerce.domain.product;

import com.zex.ecommerce.domain.product.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

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

package com.zex.ecommerce.dtos;

import com.zex.ecommerce.models.product.Category;
import com.zex.ecommerce.models.product.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductDTO(UUID id,
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


    public ProductDTO(Product product) {
        this(product.getId(), product.getName(), product.getDescription(), product.getValue(), product.getStock(),
                product.getCategory());
    }
}

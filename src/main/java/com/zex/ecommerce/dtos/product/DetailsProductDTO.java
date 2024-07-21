package com.zex.ecommerce.dtos.product;

import com.zex.ecommerce.models.product.Category;
import com.zex.ecommerce.models.product.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record DetailsProductDTO(UUID id,
                                String name,
                                String description,
                                BigDecimal value,
                                Integer stock,
                                Category category,
                                LocalDate registerDate
                                ) {

    public DetailsProductDTO(Product product) {
        this(product.getId(), product.getName(), product.getDescription(), product.getValue(), product.getStock(),
                product.getCategory(), product.getRegisterDate());
    }
}

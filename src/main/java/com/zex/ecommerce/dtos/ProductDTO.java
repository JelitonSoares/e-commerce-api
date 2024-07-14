package com.zex.ecommerce.dtos;

import com.zex.ecommerce.models.product.Category;
import com.zex.ecommerce.models.product.Product;

import java.math.BigDecimal;

public record ProductDTO(String name,
                         String description,
                         BigDecimal value,
                         Integer stock,
                         Category category) {


    public ProductDTO(Product product) {
        this(product.getName(), product.getDescription(), product.getValue(), product.getStock(),
                product.getCategory());
    }
}

package com.zex.ecommerce.domain.product;

import java.math.BigDecimal;
import java.util.UUID;

public record SimplifiedProductDTO(String id,
                                   String name,
                                   String description,
                                   BigDecimal value) {

    public SimplifiedProductDTO(Product product) {
        this(product.getId(), product.getName(), product.getDescription(), product.getValue());
    }
}

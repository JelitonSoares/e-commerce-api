package com.zex.ecommerce.domain.product;

import java.util.UUID;

public record SimplifiedProductDTO(UUID id,
                                   String name,
                                   String description) {

    public SimplifiedProductDTO(Product product) {
        this(product.getId(), product.getName(), product.getDescription());
    }
}

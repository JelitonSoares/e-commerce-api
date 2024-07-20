package com.zex.ecommerce.dtos.order;

import com.zex.ecommerce.models.ordereditens.OrderedItens;

import java.util.List;
import java.util.UUID;

public record OrderedProductsDTO(UUID productId,
                                 Integer amount) {

    public OrderedProductsDTO(OrderedItens data) {
        this(data.getId(), data.getAmount());
    }
}

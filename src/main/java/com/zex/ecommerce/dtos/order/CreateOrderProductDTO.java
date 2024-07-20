package com.zex.ecommerce.dtos.order;

import com.zex.ecommerce.models.ordereditens.OrderedItens;

import java.util.UUID;

public record CreateOrderProductDTO(UUID productId,
                                    Integer amount) {

    public CreateOrderProductDTO(OrderedItens data) {
        this(data.getId(), data.getAmount());
    }
}

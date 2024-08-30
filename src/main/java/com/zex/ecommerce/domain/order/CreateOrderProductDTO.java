package com.zex.ecommerce.domain.order;

import com.zex.ecommerce.domain.ordereditens.OrderedItens;

import java.util.UUID;

public record CreateOrderProductDTO(UUID productId,
                                    Integer amount) {

    public CreateOrderProductDTO(OrderedItens data) {
        this(data.getId(), data.getAmount());
    }
}

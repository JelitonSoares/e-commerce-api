package com.zex.ecommerce.domain.order;

import com.zex.ecommerce.domain.ordereditens.OrderedItens;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateOrderProductDTO(@NotNull String productId,
                                    @NotNull
                                    Integer amount) {

    public CreateOrderProductDTO(OrderedItens data) {
        this(data.getId(), data.getAmount());
    }
}

package com.zex.ecommerce.domain.order;

import com.zex.ecommerce.domain.ordereditens.OrderedItens;

import java.math.BigDecimal;
import java.util.UUID;

public record DetailsProductOrderDTO(UUID id,
                                     String name,
                                     Integer amount,
                                     BigDecimal unitaryValue
                                     ) {

    public DetailsProductOrderDTO(OrderedItens itens) {
        this(itens.getProduct().getId(), itens.getProduct().getName(), itens.getAmount(), itens.getUnitaryValue());
    }
}

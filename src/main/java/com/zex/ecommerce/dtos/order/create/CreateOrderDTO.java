package com.zex.ecommerce.dtos.order.create;

import com.zex.ecommerce.models.order.Order;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record CreateOrderDTO(UUID id,
                             UUID clientId,
                             List<CreateOrderProductDTO> products) {

    public CreateOrderDTO(Order data) {
        this(data.getId(), data.getClient().getId(),  data.getOrderedItensList().stream()
                .map(i -> new CreateOrderProductDTO(i)).collect(Collectors.toList()));
    }
}

package com.zex.ecommerce.dtos.order;

import com.zex.ecommerce.models.order.Order;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record OrderDTO(UUID id,
                       UUID clientId,
                       List<OrderedProductsDTO> products) {

    public OrderDTO(Order data) {
        this(data.getId(), data.getClient().getId(),  data.getOrderedItensList().stream()
                .map(i -> new OrderedProductsDTO(i)).collect(Collectors.toList()));
    }
}

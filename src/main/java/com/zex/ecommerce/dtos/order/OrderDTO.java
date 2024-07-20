package com.zex.ecommerce.dtos.order;

import com.zex.ecommerce.models.order.Order;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record OrderDTO(UUID id,
                       ClientOrderDTO client,
                       LocalDate orderDate,
                       BigDecimal totalValue,
                       List<ProductOrderDTO> itemsDTOList) {

    public OrderDTO(Order data) {
        this(data.getId(), new ClientOrderDTO(data.getClient()), data.getOrderDate(), data.getTotalValue(),
                data.getOrderedItensList().stream()
                        .map(i -> new ProductOrderDTO(i))
                        .collect(Collectors.toList()));
    }
}

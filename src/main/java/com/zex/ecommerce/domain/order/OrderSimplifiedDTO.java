package com.zex.ecommerce.domain.order;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record OrderSimplifiedDTO(UUID orderId,
                                 String clientName,
                                 LocalDate orderDate,
                                 BigDecimal totalValue) {


    public OrderSimplifiedDTO(Order order) {
        this(order.getId(), order.getClient().getName(), order.getOrderDate(), order.getTotalValue());
    }
}

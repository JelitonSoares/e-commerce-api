package com.zex.ecommerce.domain.order;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record SimplifiedOrderDTO(String orderId,
                                 String clientName,
                                 LocalDate orderDate,
                                 BigDecimal totalValue) {


    public SimplifiedOrderDTO(Order order) {
        this(order.getId(), order.getClient().getName(), order.getOrderDate(), order.getTotalValue());
    }
}

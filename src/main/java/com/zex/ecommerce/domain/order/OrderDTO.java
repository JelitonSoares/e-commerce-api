package com.zex.ecommerce.domain.order;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record OrderDTO(UUID id,
                       ClientOrderDTO client,
                       LocalDate orderDate,
                       BigDecimal totalValue,
                       @JsonProperty("orderedItems") List<ProductOrderDTO> itemsDTOList) {

    public OrderDTO(Order data) {
        this(data.getId(), new ClientOrderDTO(data.getClient()), data.getOrderDate(), data.getTotalValue(),
                data.getOrderedItensList().stream()
                        .map(i -> new ProductOrderDTO(i))
                        .collect(Collectors.toList()));
    }
}

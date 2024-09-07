package com.zex.ecommerce.domain.order;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record DetailsOrderDTO(UUID id,
                              DetailsClientOrderDTO client,
                              LocalDate orderDate,
                              BigDecimal totalValue,
                              @JsonProperty("orderedItems") List<DetailsProductOrderDTO> itemsDTOList) {

    public DetailsOrderDTO(Order data) {
        this(data.getId(), new DetailsClientOrderDTO(data.getClient()), data.getOrderDate(), data.getTotalValue(),
                data.getOrderedItensList().stream()
                        .map(i -> new DetailsProductOrderDTO(i))
                        .collect(Collectors.toList()));
    }
}

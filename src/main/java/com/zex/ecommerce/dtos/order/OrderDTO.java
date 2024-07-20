package com.zex.ecommerce.dtos.order;

import java.util.List;
import java.util.UUID;

public record OrderDTO(UUID id,
                       UUID clientId,
                       List<OrderedProductsDTO> products) {
}

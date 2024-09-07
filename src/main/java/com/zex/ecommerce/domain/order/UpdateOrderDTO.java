package com.zex.ecommerce.domain.order;

import java.util.UUID;

public record UpdateOrderDTO(UUID orderId,
                             UUID productId,
                             Integer amount) {
}

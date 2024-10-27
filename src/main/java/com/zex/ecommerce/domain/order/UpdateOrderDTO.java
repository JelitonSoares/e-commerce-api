package com.zex.ecommerce.domain.order;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UpdateOrderDTO(@NotNull String orderId,
                             @NotNull
                             UUID productId,
                             @NotNull
                             Integer amount) {
}

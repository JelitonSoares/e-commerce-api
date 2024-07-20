package com.zex.ecommerce.dtos.order;

import java.util.UUID;

public record OrderedProductsDTO(UUID productId,
                                 Integer amount) {
}

package com.zex.ecommerce.dtos.client;

import java.util.UUID;

public record ClientDTO(UUID id,
                        String name,
                        String document,
                        AddressDTO address) {
}

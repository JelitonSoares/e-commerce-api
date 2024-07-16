package com.zex.ecommerce.dtos.client;

import java.util.UUID;

public record UpdateClientDTO(UUID id,
                              String name,
                              AddressDTO address
                              ) {
}

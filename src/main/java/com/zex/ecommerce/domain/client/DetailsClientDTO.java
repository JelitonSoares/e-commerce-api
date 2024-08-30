package com.zex.ecommerce.domain.client;

import java.util.UUID;

public record DetailsClientDTO(UUID id,
                               String name,
                               String document,
                               DetailsAddressDTO address
                               ) {
   public DetailsClientDTO(Client client) {
       this(client.getId(), client.getName(), client.getDocument(), new DetailsAddressDTO(client.getAddress()));
   }
}

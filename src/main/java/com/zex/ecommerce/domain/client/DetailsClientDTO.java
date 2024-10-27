package com.zex.ecommerce.domain.client;

import java.util.UUID;

public record DetailsClientDTO(String id,
                               String name,
                               String document,
                               DetailsAddressDTO address
                               ) {
   public DetailsClientDTO(Client client) {
       this(client.getId(), client.getName(), client.getDocument(), new DetailsAddressDTO(client.getAddress()));
   }
}

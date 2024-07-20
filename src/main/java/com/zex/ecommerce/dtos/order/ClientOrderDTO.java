package com.zex.ecommerce.dtos.order;

import com.zex.ecommerce.models.client.Client;

import java.util.UUID;

public record ClientOrderDTO(UUID id,
                             String name,
                             String document) {

    public ClientOrderDTO(Client client) {
        this(client.getId(), client.getName(), client.getDocument());
    }
}

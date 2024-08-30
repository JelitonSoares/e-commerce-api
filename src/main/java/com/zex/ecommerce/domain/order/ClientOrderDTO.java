package com.zex.ecommerce.domain.order;

import com.zex.ecommerce.domain.client.Client;

import java.util.UUID;

public record ClientOrderDTO(UUID id,
                             String name,
                             String document) {

    public ClientOrderDTO(Client client) {
        this(client.getId(), client.getName(), client.getDocument());
    }
}

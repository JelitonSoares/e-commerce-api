package com.zex.ecommerce.domain.order;

import com.zex.ecommerce.domain.client.Client;

import java.util.UUID;

public record DetailsClientOrderDTO(String id,
                                    String name,
                                    String document) {

    public DetailsClientOrderDTO(Client client) {
        this(client.getId(), client.getName(), client.getDocument());
    }
}

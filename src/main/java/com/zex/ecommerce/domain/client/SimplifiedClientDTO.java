package com.zex.ecommerce.domain.client;

import java.util.UUID;

public record SimplifiedClientDTO(String id,
                                  String name,
                                  String document) {

    public SimplifiedClientDTO(Client client) {
        this(client.getId(), client.getName(), client.getDocument());
    }
}

package com.zex.ecommerce.dtos.client;

import com.zex.ecommerce.models.client.Client;

import java.util.UUID;

public record ClientDTO(UUID id,
                        String name,
                        String document,
                        AddressDTO address) {

    public ClientDTO(Client client) {
        this(client.getId(), client.getName(), client.getDocument(), new AddressDTO(client.getAddress()));
    }
}

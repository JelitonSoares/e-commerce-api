package com.zex.ecommerce.dtos.client;

import com.zex.ecommerce.models.client.Address;

public record AddressDTO(String publicPlace,
                         Integer number,
                         String neighborhood,
                         String city,
                         String uf,
                         String cep,
                         String complement) {

    public AddressDTO(Address address) {
        this(address.getPublicPlace(), address.getNumber(), address.getNeighborhood(), address.getCity(), address.getUf(),
                address.getCep(), address.getComplement());
    }
}

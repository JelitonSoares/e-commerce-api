package com.zex.ecommerce.domain.client;

import com.zex.ecommerce.domain.client.Address;

public record DetailsAddressDTO(String publicPlace,
                                Integer number,
                                String neighborhood,
                                String city,
                                String uf,
                                String cep,
                                String complement
                                ) {

    public DetailsAddressDTO(Address address) {
        this(address.getPublicPlace(), address.getNumber(), address.getNeighborhood(), address.getCity(),
                address.getUf(), address.getCep(), address.getComplement());
    }
}

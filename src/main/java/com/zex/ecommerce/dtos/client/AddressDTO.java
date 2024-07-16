package com.zex.ecommerce.dtos.client;

public record AddressDTO(String publicPlace,
                         Integer number,
                         String neighborhood,
                         String city,
                         String uf,
                         String cep,
                         String complement) {
}

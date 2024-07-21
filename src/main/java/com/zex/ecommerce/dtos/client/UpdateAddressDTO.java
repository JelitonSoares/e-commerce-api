package com.zex.ecommerce.dtos.client;


import jakarta.validation.constraints.Pattern;

public record UpdateAddressDTO(String publicPlace,
                               Integer number,

                               String neighborhood,

                               String city,

                               String uf,

                               @Pattern(regexp = "\\d{8}")
                               String cep,
                               String complement) {

}

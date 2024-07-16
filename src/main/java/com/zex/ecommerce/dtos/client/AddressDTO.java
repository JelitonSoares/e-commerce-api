package com.zex.ecommerce.dtos.client;

import com.zex.ecommerce.models.client.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AddressDTO(@NotBlank String publicPlace,
                         Integer number,
                         @NotBlank
                         String neighborhood,
                         @NotBlank
                         String city,
                         @NotBlank
                         String uf,
                         @NotBlank
                                 @Pattern(regexp = "\\d{8}")
                         String cep,
                         String complement) {

    public AddressDTO(Address address) {
        this(address.getPublicPlace(), address.getNumber(), address.getNeighborhood(), address.getCity(), address.getUf(),
                address.getCep(), address.getComplement());
    }
}

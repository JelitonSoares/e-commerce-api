package com.zex.ecommerce.domain.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateAddressDTO(@NotBlank String publicPlace,
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

}

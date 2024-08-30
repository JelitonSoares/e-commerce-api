package com.zex.ecommerce.domain.client;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CreateClientDTO(@NotBlank
                              String name,
                              @NotBlank
                              @Pattern(regexp = "\\d{11}")
                              String document,
                              @NotNull
                              @Valid
                              CreateAddressDTO address) {

}

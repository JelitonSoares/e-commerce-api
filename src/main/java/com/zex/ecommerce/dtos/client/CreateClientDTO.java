package com.zex.ecommerce.dtos.client;

import com.zex.ecommerce.models.client.Client;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

public record CreateClientDTO(UUID id,
                              @NotBlank
                        String name,
                              @NotBlank
                        @Pattern(regexp = "\\d{11}")
                        String document,
                              @NotNull
                        @Valid
                              CreateAddressDTO address) {

    public CreateClientDTO(Client client) {
        this(client.getId(), client.getName(), client.getDocument(), new CreateAddressDTO(client.getAddress()));
    }
}

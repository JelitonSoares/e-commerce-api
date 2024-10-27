package com.zex.ecommerce.domain.client;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UpdateClientDTO(@NotNull String id,
                              String name,
                              @Valid
                              UpdateAddressDTO address
                              ) {
}

package com.zex.ecommerce.domain.order;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record CreateOrderDTO(@NotNull
                             UUID clientId,
                             @NotNull
                             @Valid
                             List<CreateOrderProductDTO> products) {


}

package com.accounts.app.rest.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CuentaRequest(
        @NotBlank
        @Pattern(regexp = "BOB|USD")
        String moneda,
        @NotNull
        Long usuarioId
) {}

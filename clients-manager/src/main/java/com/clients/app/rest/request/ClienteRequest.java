package com.clients.app.rest.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ClienteRequest(
        @NotBlank
        String nombres,
        @Email
        @NotBlank
        String correo,
        @NotBlank
        @Pattern(regexp = "BOB|USD")
        String moneda
) {}

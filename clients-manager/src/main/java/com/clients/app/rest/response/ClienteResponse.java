package com.clients.app.rest.response;

public record ClienteResponse(
        Long id,
        String nombres,
        String correo,
        String nroCuenta
) {}

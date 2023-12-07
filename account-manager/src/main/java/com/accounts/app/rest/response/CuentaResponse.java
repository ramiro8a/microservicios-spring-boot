package com.accounts.app.rest.response;

public record CuentaResponse(
        String nroCuenta,
        String moneda,
        Long id
) {
}

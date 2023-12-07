package com.clients.domain.provider.account.response;

public record CuentaResponse(
        String nroCuenta,
        String moneda,
        Long id
) {
}

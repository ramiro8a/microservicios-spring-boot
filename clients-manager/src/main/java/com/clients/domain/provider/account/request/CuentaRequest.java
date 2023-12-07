package com.clients.domain.provider.account.request;


public record CuentaRequest(
        String moneda,
        Long usuarioId
) {}

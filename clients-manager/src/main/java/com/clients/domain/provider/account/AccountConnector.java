package com.clients.domain.provider.account;

import com.clients.domain.provider.account.request.CuentaRequest;
import com.clients.domain.provider.account.response.CuentaResponse;

public interface AccountConnector {
    CuentaResponse creaCuenta(CuentaRequest request);
}

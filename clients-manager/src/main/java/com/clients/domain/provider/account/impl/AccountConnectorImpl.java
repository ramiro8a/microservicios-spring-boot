package com.clients.domain.provider.account.impl;

import com.clients.app.rest.request.ClienteRequest;
import com.clients.commons.constants.Const;
import com.clients.commons.exceptions.ProviderException;
import com.clients.domain.provider.account.AccountConnector;
import com.clients.domain.provider.account.AccountProvider;
import com.clients.domain.provider.account.request.CuentaRequest;
import com.clients.domain.provider.account.response.CuentaResponse;
import com.clients.domain.provider.auth.TokenConnector;
import com.clients.domain.provider.auth.response.TokenResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.ConnectException;

@AllArgsConstructor
@Service
public class AccountConnectorImpl implements AccountConnector {
    private final AccountProvider accounts;
    private final TokenConnector tokenConnector;
    private final HttpServletRequest request;

    //@CircuitBreaker(name="crearCuenta", fallbackMethod = "creaCuentaError")
    @Override
    public CuentaResponse creaCuenta(CuentaRequest request) {
        TokenResponse token = tokenConnector.getToken();
        String bearer = " Bearer "+token.accessToken();
        return accounts.creaCuenta(bearer,getRequestId(), request);
    }
    public CuentaResponse creaCuentaError(CuentaRequest request, Throwable throwable){
        if(throwable.getCause() instanceof ConnectException)
            throw new ProviderException("00011", "El servidor de cunetas no esta disponible");
        throw new ProviderException("00014", "El servidor no quiere contestar");
    }

    private String getRequestId(){
        return (String) request.getAttribute(Const.REQUEST_ID);
    }
}

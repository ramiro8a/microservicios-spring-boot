package com.clients.domain.provider.auth.impl;

import com.clients.commons.exceptions.ProviderException;
import com.clients.domain.provider.auth.TokenConnector;
import com.clients.domain.provider.auth.TokenProvider;
import com.clients.domain.provider.auth.response.TokenResponse;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Slf4j
@Service
public class TokenConnectorImpl implements TokenConnector {

    @Autowired
    private TokenProvider tokenProvider;

    @Value("${provider.oatuh2.client-id}")
    private String clientId;
    @Value("${provider.oatuh2.secret-client}")
    private String secretClient;

    @Override
    public TokenResponse getToken() {
        try {
            String credenciales = clientId+":"+secretClient;
            String base64 = Base64.getEncoder().encodeToString(credenciales.getBytes());
            var token = tokenProvider.getToken("Basic "+base64, "client_credentials");
            log.info(token.accessToken());
            return token;
        }catch (FeignException ex){
            log.error("Error al authenticarse: {} status: {}", ex.getMessage(), ex.status());
            throw  new ProviderException("ERROR-005", ex.getMessage());
        }
    }
}

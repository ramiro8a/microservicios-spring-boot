package com.clients.domain.provider.auth;

import com.clients.domain.provider.auth.response.TokenResponse;

public interface TokenConnector {
    TokenResponse getToken();
}

package com.auth.dto;

import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

import java.util.Set;

public record CreateClientDTO(
        String clientId,
        String clientSecret,
        Set<ClientAuthenticationMethod> authenticationMethods,
        Set<AuthorizationGrantType> authorizationGrantTypes,
        Set<String> scopes
) {}

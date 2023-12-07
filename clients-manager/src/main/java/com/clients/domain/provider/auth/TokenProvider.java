package com.clients.domain.provider.auth;

import com.clients.domain.provider.auth.response.TokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "auth-server", url = "${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
public interface TokenProvider {
    @PostMapping("/oauth2/token")
    TokenResponse getToken(@RequestHeader("Authorization") String basic, @RequestParam("grant_type") String grantType);
}

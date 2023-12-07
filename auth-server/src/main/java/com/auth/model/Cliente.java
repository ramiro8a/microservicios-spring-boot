package com.auth.model;

import com.auth.dto.CreateClientDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;

import java.util.Date;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clientId;
    private String clientSecret;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<ClientAuthenticationMethod> authenticationMethods;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<AuthorizationGrantType> authorizationGrantTypes;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> scopes;

    public static RegisteredClient toRegisteredClient(Cliente cliente){
        RegisteredClient.Builder builder = RegisteredClient.withId(cliente.getClientId())
                .clientId(cliente.getClientId())
                .clientSecret(cliente.clientSecret)
                .clientIdIssuedAt(new Date().toInstant())
                .clientAuthenticationMethods(am -> am.addAll(cliente.getAuthenticationMethods()))
                .authorizationGrantTypes(agt -> agt.addAll(cliente.getAuthorizationGrantTypes()))
                .scopes(sc->sc.addAll(cliente.getScopes()));
        return builder.build();

    }
}

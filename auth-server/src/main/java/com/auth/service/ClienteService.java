package com.auth.service;

import com.auth.dto.CreateClientDTO;
import com.auth.dto.MessageDTO;
import com.auth.model.Cliente;
import com.auth.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements RegisteredClientRepository {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void save(RegisteredClient registeredClient) {

    }

    @Override
    public RegisteredClient findById(String id) {
        return null;
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        Cliente cliente = clienteRepository.findByClientId(clientId)
                .orElseThrow(() -> new RuntimeException("CLiente no encontrado"));
        return Cliente.toRegisteredClient(cliente);
    }

    public MessageDTO create(CreateClientDTO requet){
        clienteRepository.save(toCliente(requet));
        return new MessageDTO("Cliente creado exitosamente");
    }
    private Cliente toCliente(CreateClientDTO request){
        return Cliente.builder()
                .clientId(request.clientId())
                .clientSecret(passwordEncoder.encode(request.clientSecret()))
                .authenticationMethods(request.authenticationMethods())
                .authorizationGrantTypes(request.authorizationGrantTypes())
                .scopes(request.scopes())
                .build();
    }
}

package com.clients.domain.service.impl;

import com.clients.app.rest.request.ClienteRequest;
import com.clients.app.rest.response.ClienteResponse;
import com.clients.commons.exceptions.ProviderException;
import com.clients.domain.models.Cliente;
import com.clients.domain.provider.account.AccountConnector;
import com.clients.domain.provider.account.request.CuentaRequest;
import com.clients.domain.provider.account.response.CuentaResponse;
import com.clients.domain.respository.ClienteRepository;
import com.clients.domain.service.ClientService;
import com.clients.domain.service.ProduceEvento;
import com.clients.domain.service.event.ClienteEvent;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {
    private final ClienteRepository repository;
    private final AccountConnector accountConnector;
    private final ProduceEvento produceEvento;

    @Override
    public ClienteResponse crea(ClienteRequest request) {
        Cliente cliente = repository.save(Cliente.builder()
                .nombres(request.nombres())
                .correo(request.correo())
                .build());
        CuentaResponse cuenta = accountConnector.creaCuenta(new CuentaRequest(request.moneda(), cliente.getId()));
        produceEvento.envia(new ClienteEvent(
                cliente.getId(),
                cliente.getNombres(),
                cliente.getCorreo(),
                cuenta.nroCuenta()
                ));
        return new ClienteResponse(
                cliente.getId(),
                cliente.getNombres(),
                cliente.getCorreo(),
                cuenta.nroCuenta()
                );
    }
}

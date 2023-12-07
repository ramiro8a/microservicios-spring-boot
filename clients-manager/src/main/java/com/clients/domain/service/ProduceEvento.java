package com.clients.domain.service;

import com.clients.domain.service.event.ClienteEvent;

public interface ProduceEvento {
    void envia(ClienteEvent clienteEvent);
}

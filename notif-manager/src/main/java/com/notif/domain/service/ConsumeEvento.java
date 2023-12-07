package com.notif.domain.service;

import com.notif.domain.service.event.ClienteEvent;

public interface ConsumeEvento {
    void consumeEventos(ClienteEvent clienteEvent);
}

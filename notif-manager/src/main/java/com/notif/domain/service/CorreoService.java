package com.notif.domain.service;

import com.notif.domain.service.event.ClienteEvent;

public interface CorreoService {
    void enviaCorreo(ClienteEvent clienteEvent);
}

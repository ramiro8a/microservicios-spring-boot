package com.accounts.domain.service.impl;

import com.accounts.domain.service.Notificador;
import org.springframework.stereotype.Component;

@Component
public class NotificadorEmail implements Notificador {
    @Override
    public void enviarMensaje(String mensaje) {
        //resto
    }
}

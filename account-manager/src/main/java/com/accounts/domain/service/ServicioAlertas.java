package com.accounts.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ServicioAlertas {

    private final Notificador notificador;

    public void enciarAlerta(String mensaje){
        notificador.enviarMensaje(mensaje);
    }
}

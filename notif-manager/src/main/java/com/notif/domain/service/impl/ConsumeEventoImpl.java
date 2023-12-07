package com.notif.domain.service.impl;

import com.notif.domain.service.ConsumeEvento;
import com.notif.domain.service.CorreoService;
import com.notif.domain.service.event.ClienteEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConsumeEventoImpl implements ConsumeEvento {
    @Autowired
    private CorreoService correoService;

    @KafkaListener(topics = "ClienteEvent", groupId = "event-group")
    @Override
    public void consumeEventos(ClienteEvent clienteEvent) {
        correoService.enviaCorreo(clienteEvent);
        log.info("Enviar notificacion a {}", clienteEvent.getCorreo());
    }
}

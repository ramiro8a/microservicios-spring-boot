package com.notif.domain.service.impl;

import com.notif.domain.service.ConsumeMensaje;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConsumeMensajeImpl implements ConsumeMensaje {

    @KafkaListener(topics = "mensajeSimple", groupId = "mensaje-group")
    @Override
    public void consumeMensajes(String mensaje) {
        log.info("LLego un mensaje: {}", mensaje);
    }
}

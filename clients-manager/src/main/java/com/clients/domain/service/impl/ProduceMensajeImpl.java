package com.clients.domain.service.impl;

import com.clients.domain.service.ProduceMensaje;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class ProduceMensajeImpl implements ProduceMensaje {
    @Autowired
    private KafkaTemplate<String, Object> template;

    @Override
    public void envia(String mensaje) {
        CompletableFuture<SendResult<String, Object>> future = template.send("mensajeSimple", mensaje);
        future.whenComplete((result, ex)->{
            if(ex==null){
                log.info("Mensaje enviado: {} , con offset: {}", mensaje, result.getRecordMetadata().offset());
            }else {
                log.error("Error al enviar mensaje: {}", mensaje);
            }
        });
    }
}

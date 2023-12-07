package com.clients.domain.service.impl;

import com.clients.domain.service.ProduceEvento;
import com.clients.domain.service.event.ClienteEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class ProduceEventoImpl implements ProduceEvento {
    @Autowired
    private KafkaTemplate<String, ClienteEvent> template;

    @Override
    public void envia(ClienteEvent clienteEvent) {
        CompletableFuture<SendResult<String, ClienteEvent>> future = template.send("ClienteEvent", clienteEvent);
        future.whenComplete((result, ex)->{
            if(ex==null){
                log.info("Se debe enviar confirmacion a {} offset {}", clienteEvent.getCorreo(), result.getRecordMetadata().offset());
            }else {
                log.error("Error al enviar confirmacion: {}", ex.getMessage());
            }
        });
    }
}

package com.clients.domain.service.impl;

import com.clients.domain.service.event.ClienteEvent;
import com.clients.domain.service.event.ClienteEventFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProduceEventoImplTest {
    @InjectMocks
    private ProduceEventoImpl servicio;
    @Mock
    private KafkaTemplate<String, ClienteEvent> template;

    @Test
    void enviaIsOk() {
        ClienteEvent request = ClienteEventFixture.withDefault();
        CompletableFuture<SendResult<String, ClienteEvent>> future = new CompletableFuture<>();
        future.complete(mock(SendResult.class));
        when(template.send(any(), any())).thenReturn(future);
        servicio.envia(request);
        verify(template).send("ClienteEvent", request);
    }
}
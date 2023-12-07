package com.clients.app.rest.controllers;

import com.clients.app.rest.request.ClienteRequest;
import com.clients.app.rest.response.ClienteResponse;
import com.clients.commons.api.ApiError;
import com.clients.domain.service.ProduceMensaje;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag( name = "MensajesKafka", description = """
        Esto es una descripcion  de nuestro endpoint
        """)
@Slf4j
@Validated
@RestController
@RequestMapping(path = "/kafka")
public class MensajeController {
    @Autowired
    private ProduceMensaje produceMensaje;

    @Operation(operationId = "KafkaMensaje", description = "Este endpoint recibe un mensaje y lo publica en el bus de Kafka")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Mensaje enviado a kafka", content = @Content(schema = @Schema( implementation = String.class))),
            @ApiResponse(responseCode = "401", description = "No authorizado", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "500", description = "Error generico", content = @Content(schema = @Schema( implementation = ApiError.class))),
    })
    @GetMapping(path = "/{mensaje}",  produces = {MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> crea(@PathVariable() String mensaje){
        produceMensaje.envia(mensaje);
        return new ResponseEntity<>("Mensaje entregado", HttpStatus.OK);
    }

}

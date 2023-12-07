package com.accounts.app.rest.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/account/message")
public class GatewayController {
    @GetMapping(path = "/{mensaje}",  produces = {MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> mensaje(@PathVariable() String mensaje){
        log.info("[ACCOUNT] Mensaje procesado: {}", mensaje);
        return new ResponseEntity<>("Mensaje procesado: "+mensaje, HttpStatus.OK);
    }
}

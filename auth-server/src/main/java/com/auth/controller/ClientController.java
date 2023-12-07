package com.auth.controller;

import com.auth.dto.CreateClientDTO;
import com.auth.dto.MessageDTO;
import com.auth.model.Cliente;
import com.auth.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClienteService service;

    @PostMapping("/create")
    public ResponseEntity<MessageDTO> create(@RequestBody CreateClientDTO request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }
}


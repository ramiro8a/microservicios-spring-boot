package com.accounts.app.rest.controllers;

import com.accounts.app.rest.request.CuentaRequest;
import com.accounts.app.rest.response.CuentaResponse;
import com.accounts.domain.model.Cuenta;
import com.accounts.domain.service.CuentaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping(path = "/cuenta")
public class CuentaController {
    @Autowired
    private CuentaService service;

    @PostMapping(path = "", produces = {MediaType.APPLICATION_JSON_VALUE })
    @PreAuthorize("hasAuthority('CREA_CLIENTE')")
    public ResponseEntity<CuentaResponse> crea(
            @Valid @RequestBody CuentaRequest request
    ){
        return new ResponseEntity<>(service.crea(request), HttpStatus.CREATED);
    }

    @GetMapping(path = "", produces = {MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<CuentaResponse>> buscaTodo(){
        return new ResponseEntity<>(service.buscaTodo(), HttpStatus.OK);
    }
}

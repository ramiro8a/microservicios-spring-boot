package com.accounts.domain.service.impl;

import com.accounts.app.rest.request.CuentaRequest;
import com.accounts.app.rest.response.CuentaResponse;
import com.accounts.domain.model.Cuenta;
import com.accounts.domain.repository.CuentaRepository;
import com.accounts.domain.service.CuentaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class CuentaServiceImpl implements CuentaService {
    @Autowired
    private CuentaRepository repository;
    @Override
    public CuentaResponse crea(CuentaRequest request) {
        Cuenta cuenta = repository.save(Cuenta.builder()
                .nroCuenta(UUID.randomUUID().toString())
                .moneda(request.moneda())
                .usuarioId(request.usuarioId())
                .build());
        return Cuenta.aCuentaResponse(cuenta);
    }

    @Override
    public List<CuentaResponse> buscaTodo() {
        List<Cuenta> result = repository.findAll();
        List<CuentaResponse> lista = new ArrayList<>();
        for (Cuenta cuenta: result){
            lista.add(Cuenta.aCuentaResponse(cuenta));
        }
        return lista;
    }
}

package com.notif.domain.service.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEvent {
    private Long id;
    private String nombres;
    private String correo;
    private String nroCuenta;
}

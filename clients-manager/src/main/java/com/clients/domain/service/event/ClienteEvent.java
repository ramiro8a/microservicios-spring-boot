package com.clients.domain.service.event;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEvent {
    private Long id;
    private String nombres;
    private String correo;
    private String nroCuenta;
}

package com.clients.commons.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ApiError {
    private String codigo;
    private String mensaje;
    @JsonIgnore
    private HttpStatus status;
}

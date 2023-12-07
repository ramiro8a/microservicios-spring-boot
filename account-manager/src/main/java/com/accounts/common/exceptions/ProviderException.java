package com.accounts.common.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProviderException extends RuntimeException{
    private String code;
    private String Mensaje;
}

package com.clients.app.rest.response;

public class ClienteResponseFixture {
    public static ClienteResponse withDefault(){
        return new ClienteResponse(
                1L,
                "Any name",
                "email@gmail.com",
                "1010100101"
        );
    }
}
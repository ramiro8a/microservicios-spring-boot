package com.clients.app.rest.request;

public class ClienteRequestFixture {
    public static ClienteRequest withDefaul(){
        return new ClienteRequest(
                "Any name",
                "emai@gmail.com",
                "USD"
        );
    }
}
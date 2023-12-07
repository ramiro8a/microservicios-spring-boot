package com.clients.domain.service.event;

public class ClienteEventFixture {
    public static ClienteEvent withDefault(){
        return new ClienteEvent(
                1L,
                "Any name",
                "email@gmail.com",
                "12312"
        );
    }
}
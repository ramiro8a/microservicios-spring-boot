package com.clients.app.rest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class TestUtils {
    public String asJsonString(final Object obj){
        try {
            ObjectMapper om = new ObjectMapper()
                    .findAndRegisterModules()
                    .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                    .configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false)
                    .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false );
            return om.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

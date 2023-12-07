package com.clients.commons.utils;

import com.clients.commons.constants.ErrorMsg;
import com.clients.commons.exceptions.ProviderException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Utils {
    private static final ObjectMapper obtenerMapper = creaObjectMapper();

    public static String objectToString(Object data, boolean pretty){
        try{
            ObjectWriter ow = obtenerMapper.writer();
            if(pretty)
                ow = obtenerMapper.writer().withDefaultPrettyPrinter();
            return ow.writeValueAsString(data);
        }catch (JsonProcessingException ex){
            throw new ProviderException(ErrorMsg.JSON_PROCESING.getCod(), ErrorMsg.JSON_PROCESING.getMsj());
        }
    }

    private static ObjectMapper creaObjectMapper(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }
}

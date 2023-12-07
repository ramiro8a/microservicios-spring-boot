package com.clients.app.rest.controllers;

import com.clients.app.config.RestExceptionHandler;
import com.clients.app.rest.TestUtils;
import com.clients.app.rest.request.ClienteRequest;
import com.clients.app.rest.request.ClienteRequestFixture;
import com.clients.app.rest.response.ClienteResponse;
import com.clients.app.rest.response.ClienteResponseFixture;
import com.clients.domain.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ClienteControllerTest extends TestUtils {
    private static final String URL = "/cliente";
    @InjectMocks
    private ClienteController controller;
    @Mock
    private ClientService service;

    private MockMvc mockMvc;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new RestExceptionHandler())
                .build();
    }

    @Test
    void creaIsOk() throws Exception {
        ClienteResponse expected = ClienteResponseFixture.withDefault();
        ClienteRequest request = ClienteRequestFixture.withDefaul();
        when(service.crea(any())).thenReturn(expected);
        MvcResult result = mockMvc.perform(post(URL).contentType(MediaType.APPLICATION_JSON).content(asJsonString(request)))
                .andExpect(status().isCreated())
                .andReturn();
        assertEquals(asJsonString(expected), result.getResponse().getContentAsString());
        verify(service).crea(any());
    }
}
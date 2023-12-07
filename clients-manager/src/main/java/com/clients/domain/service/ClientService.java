package com.clients.domain.service;

import com.clients.app.rest.request.ClienteRequest;
import com.clients.app.rest.response.ClienteResponse;

public interface ClientService {
    ClienteResponse crea(ClienteRequest request);
}

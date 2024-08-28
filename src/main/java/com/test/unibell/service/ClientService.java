package com.test.unibell.service;

import com.test.unibell.dto.request.ClientDtoRequest;
import com.test.unibell.dto.response.ClientDtoResponse;

import java.util.List;
import java.util.UUID;

public interface ClientService {

    ClientDtoResponse saveClient(ClientDtoRequest clientDtoRequest);

    List<ClientDtoResponse> getClients();

    ClientDtoResponse getClient(UUID id);
}

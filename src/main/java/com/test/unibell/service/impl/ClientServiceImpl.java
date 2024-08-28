package com.test.unibell.service.impl;

import com.test.unibell.dto.request.ClientDtoRequest;
import com.test.unibell.dto.response.ClientDtoResponse;
import com.test.unibell.exception.DataNotFoundException;
import com.test.unibell.mapper.ClientMapper;
import com.test.unibell.model.Client;
import com.test.unibell.repository.ClientRepository;
import com.test.unibell.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public ClientDtoResponse saveClient(ClientDtoRequest clientDtoRequest) {
        Client client = clientMapper.toEntity(clientDtoRequest);
        client = clientRepository.save(client);
        return clientMapper.toResponse(client);
    }

    @Override
    public List<ClientDtoResponse> getClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(clientMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public ClientDtoResponse getClient(UUID id) {
        Client client = clientRepository.findById(id).orElseThrow(() ->
                new DataNotFoundException("Клиент с ID: " + id + " не найден"));
        return clientMapper.toResponse(client);
    }
}

package com.test.unibell.controller;

import com.test.unibell.dto.request.ClientDtoRequest;
import com.test.unibell.dto.response.ClientDtoResponse;
import com.test.unibell.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/client")
@Tag(
        name = "Client Controller",
        description = "Контроллер для работы с клиентами"
)
public class ClientController {
    private final ClientService clientService;

    @Operation(summary = "Добавление нового клиента")
    @PutMapping
    ClientDtoResponse saveClient(@RequestBody @Validated ClientDtoRequest clientDtoRequest) {
        return clientService.saveClient(clientDtoRequest);
    }

    @Operation(summary = "Получение списка клиентов")
    @GetMapping
    List<ClientDtoResponse> getClients() {
        return clientService.getClients();
    }

    @Operation(summary = "Получение информации по заданному клиенту (по id)")
    @GetMapping("/{id}")
    ClientDtoResponse getClient(@PathVariable UUID id) {
        return clientService.getClient(id);
    }
}

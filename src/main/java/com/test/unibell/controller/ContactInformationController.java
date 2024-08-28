package com.test.unibell.controller;

import com.test.unibell.dto.request.EmailDtoRequest;
import com.test.unibell.dto.request.PhoneDtoRequest;
import com.test.unibell.model.ContactInformationType;
import com.test.unibell.service.ContactInformationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/contact-information")
@Tag(
        name = "Contact InformationController Controller",
        description = "Контроллер для работы с контактными данными клиентов"
)
public class ContactInformationController {
    private final ContactInformationService contactInformationService;

    @Operation(summary = "Добавление нового телефона для клиента")
    @PutMapping(value = "/phone")
    @ResponseStatus(HttpStatus.OK)
    void addPhone(@RequestBody @Validated PhoneDtoRequest phoneDtoRequest) {
        contactInformationService.addPhone(phoneDtoRequest);
    }

    @Operation(summary = "Добавление нового эмейла для клиента")
    @PutMapping(value = "/email")
    @ResponseStatus(HttpStatus.OK)
    void addEmail(@RequestBody @Validated EmailDtoRequest emailDtoRequest) {
        contactInformationService.addEmail(emailDtoRequest);
    }

    @Operation(summary = "Просмотр контактной информации по ID клиента")
    @GetMapping(value = "/client/{id}")
    Map<String, List<String>> getContactInformation(@PathVariable UUID id, @RequestParam(required = false) List<ContactInformationType> types) {
        return contactInformationService.getContactInformation(id, types);
    }
}

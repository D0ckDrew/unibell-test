package com.test.unibell.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDtoRequest {

    @Schema(description = "Id сотрудника",
            implementation = UUID.class,
            example = "6545edf2-86fe-479d-a9fa-ba40735e4f10")
    @NotNull
    private UUID clientId;

    @Schema(description = "Телефонный номер сотрудник", example = "+79247831122")
    @NotBlank
    private String phoneNumber;
}

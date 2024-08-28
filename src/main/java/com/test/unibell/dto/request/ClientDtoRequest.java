package com.test.unibell.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDtoRequest {

    @Schema(description = "Имя сотрудника", example = "Андрей")
    @NotBlank
    private String name;
}
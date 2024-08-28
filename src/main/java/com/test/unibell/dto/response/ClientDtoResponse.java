package com.test.unibell.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDtoResponse {

    @Schema(description = "Id сотрудника",
            implementation = UUID.class,
            example = "6545edf2-86fe-479d-a9fa-ba40735e4f10")
    private UUID id;

    @Schema(description = "Имя сотрудника", example = "Андрей")
    private String name;

    private List<String> emails;

    private List<String> phones;
}

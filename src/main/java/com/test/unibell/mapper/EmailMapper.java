package com.test.unibell.mapper;

import com.test.unibell.dto.request.EmailDtoRequest;
import com.test.unibell.model.Email;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmailMapper {

    Email toEntity(EmailDtoRequest emailDtoRequest);

}

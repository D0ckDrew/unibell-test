package com.test.unibell.mapper;

import com.test.unibell.dto.request.PhoneDtoRequest;
import com.test.unibell.model.Phone;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhoneMapper {

    Phone toEntity(PhoneDtoRequest phoneDtoRequest);
}

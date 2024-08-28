package com.test.unibell.mapper;

import com.test.unibell.dto.request.ClientDtoRequest;
import com.test.unibell.dto.response.ClientDtoResponse;
import com.test.unibell.model.Client;
import com.test.unibell.model.Email;
import com.test.unibell.model.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = ArrayList.class)
public interface ClientMapper {

    @Mapping(target = "emails", qualifiedByName = "emailsToList", source = "emails")
    @Mapping(target = "phones", qualifiedByName = "phoneToList", source = "phones")
    ClientDtoResponse toResponse(Client client);

    @Mapping(target = "emails", expression = "java(new ArrayList())")
    @Mapping(target = "phones", expression = "java(new ArrayList())")
    Client toEntity(ClientDtoRequest client);

    @Named("emailsToList")
    default List<String> emailsToList(List<Email> emails) {
        return emails.stream().map(Email::getEmailAddress).collect(Collectors.toList());
    }

    @Named("phoneToList")
    default List<String> phoneToList(List<Phone> phones) {
        return phones.stream().map(Phone::getPhoneNumber).collect(Collectors.toList());
    }

}

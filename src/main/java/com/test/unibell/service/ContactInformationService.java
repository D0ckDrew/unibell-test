package com.test.unibell.service;

import com.test.unibell.dto.request.EmailDtoRequest;
import com.test.unibell.dto.request.PhoneDtoRequest;
import com.test.unibell.model.ContactInformationType;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface ContactInformationService {

    void addPhone(PhoneDtoRequest phoneDtoRequest);

    void addEmail(EmailDtoRequest emailDtoRequest);

    Map<String, List<String>> getContactInformation(UUID id, List<ContactInformationType> types);
}

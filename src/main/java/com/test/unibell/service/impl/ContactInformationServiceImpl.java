package com.test.unibell.service.impl;

import com.test.unibell.dto.request.EmailDtoRequest;
import com.test.unibell.dto.request.PhoneDtoRequest;
import com.test.unibell.exception.DataNotFoundException;
import com.test.unibell.mapper.EmailMapper;
import com.test.unibell.mapper.PhoneMapper;
import com.test.unibell.model.ContactInformationType;
import com.test.unibell.model.Email;
import com.test.unibell.model.Phone;
import com.test.unibell.repository.ClientRepository;
import com.test.unibell.repository.EmailRepository;
import com.test.unibell.repository.PhoneRepository;
import com.test.unibell.service.ContactInformationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ContactInformationServiceImpl implements ContactInformationService {
    private final EmailRepository emailRepository;
    private final PhoneRepository phoneRepository;
    private final ClientRepository clientRepository;

    private final EmailMapper emailMapper;
    private final PhoneMapper phoneMapper;

    @Override
    public void addPhone(PhoneDtoRequest phoneDtoRequest) {
        checkClientExists(phoneDtoRequest.getClientId());
        Phone phone = phoneMapper.toEntity(phoneDtoRequest);
        phoneRepository.save(phone);
    }

    @Override
    public void addEmail(EmailDtoRequest emailDtoRequest) {
        checkClientExists(emailDtoRequest.getClientId());
        Email email = emailMapper.toEntity(emailDtoRequest);
        emailRepository.save(email);
    }

    @Override
    public Map<String, List<String>> getContactInformation(UUID clientId, List<ContactInformationType> types) {
        checkClientExists(clientId);
        if (types == null || types.isEmpty()) {
            types = List.of(ContactInformationType.values());
        }

        Map<String, List<String>> result = new HashMap<>();
        for (ContactInformationType type : types) {
            switch (type) {
                case EMAIL -> {
                    List<Email> emails = emailRepository.findAllByClientId(clientId);
                    result.put(type.name(), emails.stream().map(Email::getEmailAddress).collect(Collectors.toList()));
                }
                case PHONE -> {
                    List<Phone> phones = phoneRepository.findAllByClientId(clientId);
                    result.put(type.name(), phones.stream().map(Phone::getPhoneNumber).collect(Collectors.toList()));
                }
            }
        }
        return result;
    }

    private void checkClientExists(UUID clientId) {
        if (!clientRepository.existsById(clientId)) {
            throw new DataNotFoundException("Клиент с ID: " + clientId + " не найден");
        }
    }
}

package com.test.unibell.repository;

import com.test.unibell.model.Phone;
import com.test.unibell.model.PhoneId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, PhoneId> {

    List<Phone> findAllByClientId(UUID clientId);
}

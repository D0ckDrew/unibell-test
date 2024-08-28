package com.test.unibell.repository;

import com.test.unibell.model.Email;
import com.test.unibell.model.EmailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmailRepository extends JpaRepository<Email, EmailId> {

    List<Email> findAllByClientId(UUID clientId);
}

package com.test.unibell.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.UUID;

@Entity
@Table(name = "email", schema = "public")
@IdClass(EmailId.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Email {

    @Id
    @Column(name = "client_id")
    @JdbcTypeCode(Types.VARCHAR)
    @NonNull
    private UUID clientId;

    @Id
    @Column(name = "email_address")
    @NonNull
    private String emailAddress;
}

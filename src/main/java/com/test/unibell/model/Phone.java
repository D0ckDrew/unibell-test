package com.test.unibell.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.UUID;

@Entity
@Table(name = "phone", schema = "public")
@IdClass(PhoneId.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Phone {

    @Id
    @Column(name = "client_id")
    @JdbcTypeCode(Types.VARCHAR)
    @NonNull
    private UUID clientId;

    @Id
    @Column(name = "phone_number")
    @NonNull
    private String phoneNumber;
}

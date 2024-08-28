--liquibase formatted sql
--changeset dockdrew:create_tables

CREATE TABLE client
(
    id              VARCHAR(255)    NOT NULL    PRIMARY KEY,
    name            VARCHAR(255)    NOT NULL
);

CREATE TABLE phone
(
    client_id         VARCHAR(255)    NOT NULL,
    phone_number    VARCHAR(255)    NOT NULL,
    PRIMARY KEY (client_id, phone_number),
    CONSTRAINT fk_phone_client FOREIGN KEY (client_id) REFERENCES client (id)
);

CREATE TABLE email
(
    client_id         VARCHAR(255)    NOT NULL,
    email_address   VARCHAR(255)    NOT NULL,
    PRIMARY KEY (client_id, email_address),
    CONSTRAINT fk_email_client FOREIGN KEY (client_id) REFERENCES client (id)
);



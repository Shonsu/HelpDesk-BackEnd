--liquibase formatted sql
--changeset shonsu:24
ALTER TABLE ticket
    ADD open_date      TIMESTAMP,
    ADD terminate_date TIMESTAMP;

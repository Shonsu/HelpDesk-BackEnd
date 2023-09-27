--liquibase formatted sql
--changeset shonsu:25
ALTER TABLE ticket
    ALTER COLUMN expiry_date DROP NOT NULL;

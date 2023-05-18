--liquibase formatted sql
--changeset shonsu:20
ALTER TABLE ticket
ALTER COLUMN create_date TYPE TIMESTAMP WITH TIME ZONE,
ALTER COLUMN expiry_date TYPE TIMESTAMP WITH TIME ZONE;

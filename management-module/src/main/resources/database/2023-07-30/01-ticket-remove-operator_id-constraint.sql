--liquibase formatted sql
--changeset shonsu:21
ALTER TABLE ticket
ALTER COLUMN operator_id DROP NOT NULL;

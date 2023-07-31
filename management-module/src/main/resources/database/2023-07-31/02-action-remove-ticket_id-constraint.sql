--liquibase formatted sql
--changeset shonsu:23
ALTER TABLE "action"
ALTER COLUMN ticket_id DROP NOT NULL;

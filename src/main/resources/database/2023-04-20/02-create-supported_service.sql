--liquibase formatted sql
--changeset shonsu:11
create table supported_service(
    id SERIAL PRIMARY KEY,
    code VARCHAR(5) NOT NULL
);
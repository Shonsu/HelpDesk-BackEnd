--liquibase formatted sql
--changeset shonsu:10
create table handling_group(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
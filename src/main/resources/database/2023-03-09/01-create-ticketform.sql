--liquibase formatted sql
--changeset shonsu:1
CREATE TABLE ticket_form
(
    id              SERIAL PRIMARY KEY,
    category_id     BIGINT NOT NULL,
    sub_category_id BIGINT NOT NULL
);



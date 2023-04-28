--liquibase formatted sql
--changeset shonsu:4
create table ticket_category
(
    id          SERIAL PRIMARY KEY,
    label       VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL
);
--changeset shonsu:5
create table ticket_sub_category
(
    id                 SERIAL PRIMARY KEY,
    label              VARCHAR(255) NOT NULL,
    description        VARCHAR(255) NOT NULL,
    ticket_category_id INT,
    CONSTRAINT fk_ticket_sub_category_ticket_category_id FOREIGN KEY (ticket_category_id) REFERENCES ticket_category (id)
)

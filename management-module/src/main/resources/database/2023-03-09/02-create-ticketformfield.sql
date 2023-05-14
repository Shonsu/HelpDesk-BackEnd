--liquibase formatted sql
--changeset shonsu:2
CREATE TABLE ticket_form_field
(
    id             SERIAL PRIMARY KEY,
    "key"          VARCHAR(255) NOT NULL,
    label          VARCHAR(255) NOT NULL,
    required       BOOLEAN      NOT NULL,
    "order"        SMALLINT     NOT NULL,
    control_type   VARCHAR(25),
    ticket_form_id INT
);

alter table ticket_form_field
    add constraint fk_ticket_form_field_ticket_form_id foreign key (ticket_form_id) references ticket_form (id);
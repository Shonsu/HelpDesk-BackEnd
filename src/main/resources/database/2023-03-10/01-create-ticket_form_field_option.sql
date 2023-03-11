--liquibase formatted sql
--changeset shonsu:3
create table ticket_form_field_option
(
    id                   SERIAL PRIMARY KEY,
    "key"                varchar(255) not null,
    value                varchar(255) not null,
    ticket_form_field_id INT
);

alter table ticket_form_field_option
    add constraint fk_ticket_form_field_option_ticket_form_field_id foreign key (ticket_form_field_id) references ticket_form_field (id);
--liquibase formatted sql
--changeset shonsu:9
alter table ticket_form_field
    alter column "key" drop not null;
alter table ticket_form_field
    alter column label drop not null;
alter table ticket_form_field
    alter column required drop not null;
alter table ticket_form_field
    alter column "order" drop not null;
--liquibase formatted sql
--changeset shonsu:8
alter table ticket_form_field
    add type varchar(32);
--liquibase formatted sql
--changeset shonsu:6
alter table ticket_form
    drop column category_id;
--liquibase formatted sql
--changeset shonsu:18
alter table ticket_sub_category
alter column ticket_category_id set not null;

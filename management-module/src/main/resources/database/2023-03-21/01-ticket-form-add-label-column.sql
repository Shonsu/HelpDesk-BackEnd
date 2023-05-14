--liquibase formatted sql
--changeset shonsu:7
alter table ticket_form add label varchar(255);

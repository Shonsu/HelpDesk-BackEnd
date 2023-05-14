--liquibase formatted sql
--changeset shonsu:14
alter table supported_service add constraint supported_service_code_key unique(code);

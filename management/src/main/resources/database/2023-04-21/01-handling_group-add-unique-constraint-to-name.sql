--liquibase formatted sql
--changeset shonsu:13
alter table handling_group add constraint handling_group_name_key UNIQUE (name);

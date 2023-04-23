--liquibase formatted sql
--changeset shonsu:12
create table handling_group_supported_service(
handling_group_id BIGINT NOT NULL,
supported_service_id BIGINT NOT NULL,
constraint fk_handling_group_supported_service_handling_group_id foreign key (handling_group_id) references handling_group(id),
constraint fk_handling_group_supported_service_supported_service_id foreign key (supported_service_id) references supported_service(id)
);

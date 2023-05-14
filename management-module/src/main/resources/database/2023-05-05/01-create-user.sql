--liquibase formatted sql
--changeset shonsu:15
create table "user"
(
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    authorities JSONB,
    enabled BOOLEAN,
    email VARCHAR(100)
);
--changeset shonsu:16
insert into "user"(username, password, authorities, enabled, email)
values('admin', '$2a$10$DUyF7hMfDuv72qnRdSRkv.Nmbmqb.ITH8Sygyx2FQXi20XNpISGDK', json_build_object('userRoles', jsonb_build_array('ROLE_ADMIN', 'ROLE_USER')), true, 'admin@com.pl');
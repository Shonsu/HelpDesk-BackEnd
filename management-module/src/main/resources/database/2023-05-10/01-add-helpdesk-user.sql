--liquibase formatted sql
--changeset shonsu:17
insert into "user"(username, password, authorities, enabled, email)
values(
    'helpdesk',
    '$2a$10$H05rz68LyQ7GgkqpMjch/.QQYEFsL27P7Er.8L3e.9YOSm1oKgfau',
    json_build_object('userRoles', jsonb_build_array('ROLE_HELPDESK')),
    true,
    'helpdesk@com.pl'
);
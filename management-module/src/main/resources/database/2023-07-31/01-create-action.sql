--liquibase formatted sql
--changeset shonsu:22
create table "action"(
    id          SERIAL PRIMARY KEY,
    user_id     BIGINT NOT NULL,
    status      VARCHAR(50) NOT NULL,
    description TEXT,
    "timestamp" TIMESTAMP NOT NULL,
    ticket_id   BIGINT NOT NULL,
    constraint fk_action_user_id foreign key (user_id) references "user"(id),
    constraint fk_action_ticket_id foreign key (ticket_id) references ticket(id)
)

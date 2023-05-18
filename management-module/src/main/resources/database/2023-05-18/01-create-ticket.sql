--liquibase formatted sql
--changeset shonsu:19
create table ticket(
    id              SERIAL PRIMARY KEY,
    creator_id BIGINT NOT NULL,
    operator_id BIGINT NOT NULL,
    create_date     TIMESTAMP NOT NULL,
    expiry_date     TIMESTAMP NOT NULL,
    content         JSONB NOT NULL,
    status          VARCHAR(50) NOT NULL,
    constraint fk_ticket_creator_id foreign key (creator_id) references "user"(id),
    constraint fk_ticket_operator_id foreign key (operator_id) references "user"(id)
)
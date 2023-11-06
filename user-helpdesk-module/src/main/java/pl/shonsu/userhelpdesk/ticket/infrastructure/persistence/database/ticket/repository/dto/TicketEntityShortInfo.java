package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.repository.dto;

import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.entity.Status;

import java.time.Instant;

public record TicketEntityShortInfo(Long id, Long ticketFormId, Instant createdAt, Status status) {
}

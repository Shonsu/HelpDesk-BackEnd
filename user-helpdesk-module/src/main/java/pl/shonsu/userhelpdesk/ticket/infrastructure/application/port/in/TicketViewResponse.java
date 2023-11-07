package pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in;

import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.entity.Status;

import java.time.Instant;

public record TicketViewResponse(Long id, String title, Instant created, Status status) {
}

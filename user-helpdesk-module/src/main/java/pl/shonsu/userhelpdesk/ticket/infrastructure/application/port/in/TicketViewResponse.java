package pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in;

import java.time.Instant;

public record TicketViewResponse(Long id, String title, Instant created) {
}

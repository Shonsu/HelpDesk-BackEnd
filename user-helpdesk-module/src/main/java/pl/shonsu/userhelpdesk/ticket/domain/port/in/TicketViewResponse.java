package pl.shonsu.userhelpdesk.ticket.domain.port.in;

import java.time.LocalDateTime;

public record TicketViewResponse(Long id, String title, LocalDateTime created) {
}

package pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in;

import jakarta.validation.constraints.NotNull;
import pl.shonsu.userhelpdesk.ticket.domain.model.creator.CreatorId;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.TicketId;

public record CancelTicketCommand(@NotNull TicketId ticketId, @NotNull CreatorId creatorId, @NotNull String description) {
}

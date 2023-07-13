package pl.shonsu.userhelpdesk.ticket.domain.port.in;

import jakarta.validation.constraints.NotNull;
import pl.shonsu.userhelpdesk.ticket.domain.model.creator.CreatorId;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.Content;

public record RegisterTicketCommand(
        @NotNull CreatorId creatorId,
        @NotNull Content content
) {
}

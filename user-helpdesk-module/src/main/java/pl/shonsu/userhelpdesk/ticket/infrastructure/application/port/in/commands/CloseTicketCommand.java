package pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.commands;

import jakarta.validation.constraints.NotNull;
import pl.shonsu.userhelpdesk.ticket.domain.model.operator.OperatorId;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.TicketId;

public record CloseTicketCommand(@NotNull TicketId ticketId, @NotNull OperatorId operatorId,
                                 @NotNull String description) {
}

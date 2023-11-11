package pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in;

import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.commands.OpenTicketCommand;

public interface OpenTicketUseCase {
    boolean openTicket(OpenTicketCommand command);
}
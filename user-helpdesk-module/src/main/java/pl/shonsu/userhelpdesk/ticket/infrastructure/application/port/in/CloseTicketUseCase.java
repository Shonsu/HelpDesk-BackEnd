package pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in;

import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.commands.CloseTicketCommand;

public interface CloseTicketUseCase {
    boolean closeTicket(CloseTicketCommand command);
}

package pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in;

import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.commands.RegisterTicketCommand;

public interface RegisterTicketUseCase {
    boolean registerTicket(RegisterTicketCommand command);
}

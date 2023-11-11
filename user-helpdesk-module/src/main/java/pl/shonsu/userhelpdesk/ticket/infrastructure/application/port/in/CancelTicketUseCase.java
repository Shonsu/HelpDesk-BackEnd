package pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in;

import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.commands.CancelTicketCommand;

public interface CancelTicketUseCase {
    void cancelTicket(CancelTicketCommand command);
}
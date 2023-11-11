package pl.shonsu.userhelpdesk.ticket.infrastructure.application.service;

import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.Ticket;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.commands.CancelTicketCommand;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.CancelTicketUseCase;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.out.LoadTicketPort;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.out.UpdateTicketPort;

public class CancelTicketService implements CancelTicketUseCase {

    private final LoadTicketPort loadTicketPort;
    private final UpdateTicketPort updateTicketPort;

    public CancelTicketService(LoadTicketPort loadTicketPort, UpdateTicketPort updateTicketPort) {
        this.loadTicketPort = loadTicketPort;
        this.updateTicketPort = updateTicketPort;
    }

    @Override
    public void cancelTicket(CancelTicketCommand command) {
        Ticket ticket = loadTicketPort.loadTicket(command.ticketId());
        Ticket cancel = ticket.cancel();
        updateTicketPort.updateTicket(cancel);
    }
}

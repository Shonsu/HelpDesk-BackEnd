package pl.shonsu.userhelpdesk.ticket.infrastructure.application.service;

import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.Ticket;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.CloseTicketCommand;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.CloseTicketUseCase;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.out.LoadTicketPort;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.out.UpdateTicketPort;

public class CloseTicketService implements CloseTicketUseCase {

    private final LoadTicketPort loadTicketPort;
    private final UpdateTicketPort updateTicketPort;
    public CloseTicketService(LoadTicketPort loadTicketPort, UpdateTicketPort updateTicketPort) {
        this.loadTicketPort = loadTicketPort;
        this.updateTicketPort = updateTicketPort;
    }

    @Override
    public boolean closeTicket(CloseTicketCommand command) {
        Ticket ticket = loadTicketPort.loadTicket(command.ticketId());
        Ticket close = ticket.close(command.operatorId(), command.description());
        updateTicketPort.updateTicket(close);
        return true;
    }
}

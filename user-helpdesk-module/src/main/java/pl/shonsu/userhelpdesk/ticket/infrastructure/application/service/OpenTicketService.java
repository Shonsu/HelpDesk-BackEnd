package pl.shonsu.userhelpdesk.ticket.infrastructure.application.service;

import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.Ticket;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.OpenTicketCommand;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.OpenTicketUseCase;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.out.LoadTicketPort;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.out.UpdateTicketPort;

public class OpenTicketService implements OpenTicketUseCase {
    private final LoadTicketPort loadTicketPort;
    private final UpdateTicketPort updateTicketPort;

    public OpenTicketService(LoadTicketPort loadTicketPort, UpdateTicketPort updateTicketPort) {
        this.loadTicketPort = loadTicketPort;
        this.updateTicketPort = updateTicketPort;
    }

    @Override
    public boolean openTicket(OpenTicketCommand command) {
        Ticket ticket = loadTicketPort.loadTicket(command.ticketI());
        Ticket open = ticket.open(command.operatorId());
        updateTicketPort.updateTicket(open);
        return true;
    }
}

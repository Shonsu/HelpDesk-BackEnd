package pl.shonsu.userhelpdesk.ticket.domain.service;

import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.Ticket;
import pl.shonsu.userhelpdesk.ticket.domain.port.in.RegisterTicketCommand;
import pl.shonsu.userhelpdesk.ticket.domain.port.in.RegisterTicketUseCase;
import pl.shonsu.userhelpdesk.ticket.domain.port.out.CreateTicketPort;

public class RegisterTicketService implements RegisterTicketUseCase {
    private final CreateTicketPort createTicketPort;

    public RegisterTicketService(CreateTicketPort createTicketPort) {
        this.createTicketPort = createTicketPort;
    }

    @Override
    public boolean registerTicket(RegisterTicketCommand registerTicketCommand) {
        Ticket ticket = Ticket.create(
                registerTicketCommand.creatorId(),
                registerTicketCommand.content()
        );
        createTicketPort.createTicket(ticket);
        return true;
    }
}

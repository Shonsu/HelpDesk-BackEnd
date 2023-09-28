package pl.shonsu.userhelpdesk.ticket.domain.service;

import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.Ticket;
import pl.shonsu.userhelpdesk.ticket.domain.port.in.RegisterTicketCommand;
import pl.shonsu.userhelpdesk.ticket.domain.port.in.RegisterTicketUseCase;
import pl.shonsu.userhelpdesk.ticket.domain.port.in.TicketContentVerifier;
import pl.shonsu.userhelpdesk.ticket.domain.port.out.CreateTicketPort;

public class RegisterTicketService implements RegisterTicketUseCase {
    private final CreateTicketPort createTicketPort;
    private final TicketContentVerifier ticketContentVerifier;

    public RegisterTicketService(CreateTicketPort createTicketPort, TicketContentVerifier ticketContentVerifier) {
        this.createTicketPort = createTicketPort;
        this.ticketContentVerifier = ticketContentVerifier;
    }

    @Override
    public boolean registerTicket(RegisterTicketCommand registerTicketCommand) {
        Ticket ticket = Ticket.create(
                registerTicketCommand.creatorId(),
                registerTicketCommand.content()
        );
        ticketContentVerifier.isTicketContentValid(ticket.getContent());
        createTicketPort.createTicket(ticket);
        return true;
    }
}

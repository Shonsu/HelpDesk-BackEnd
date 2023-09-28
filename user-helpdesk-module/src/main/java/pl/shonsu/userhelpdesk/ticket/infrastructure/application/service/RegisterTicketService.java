package pl.shonsu.userhelpdesk.ticket.infrastructure.application.service;

import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.Ticket;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.RegisterTicketCommand;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.RegisterTicketUseCase;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.TicketContentVerifier;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.out.CreateTicketPort;

public class RegisterTicketService implements RegisterTicketUseCase {
    private final CreateTicketPort createTicketPort;
    private final TicketContentVerifier ticketContentVerifier;

    public RegisterTicketService(CreateTicketPort createTicketPort, TicketContentVerifier ticketContentVerifier) {
        this.createTicketPort = createTicketPort;
        this.ticketContentVerifier = ticketContentVerifier;
    }

    @Override
    public boolean registerTicket(RegisterTicketCommand command) {
        Ticket ticket = Ticket.create(
                command.creatorId(),
                command.content()
        );
        ticketContentVerifier.isTicketContentValid(ticket.getContent());
        createTicketPort.createTicket(ticket);
        return true;
    }
}

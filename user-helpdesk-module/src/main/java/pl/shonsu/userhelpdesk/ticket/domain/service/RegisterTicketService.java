package pl.shonsu.userhelpdesk.ticket.domain.service;

import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.Ticket;
import pl.shonsu.userhelpdesk.ticket.domain.port.in.RegisterTicketCommand;
import pl.shonsu.userhelpdesk.ticket.domain.port.in.RegisterTicketUseCase;
import pl.shonsu.userhelpdesk.ticket.domain.port.in.TicketContentVerfifier;
import pl.shonsu.userhelpdesk.ticket.domain.port.out.CreateTicketPort;

public class RegisterTicketService implements RegisterTicketUseCase {
    private final CreateTicketPort createTicketPort;
    private final TicketContentVerfifier ticketContentVerfifier;

    public RegisterTicketService(CreateTicketPort createTicketPort, TicketContentVerfifier ticketContentVerfifier) {
        this.createTicketPort = createTicketPort;
        this.ticketContentVerfifier = ticketContentVerfifier;
    }

    @Override
    public boolean registerTicket(RegisterTicketCommand registerTicketCommand) {
        Ticket ticket = Ticket.create(
                registerTicketCommand.creatorId(),
                registerTicketCommand.content()
        );
        ticketContentVerfifier.isTicketContentValid(ticket.getContent());
        createTicketPort.createTicket(ticket);
        return true;
    }
}

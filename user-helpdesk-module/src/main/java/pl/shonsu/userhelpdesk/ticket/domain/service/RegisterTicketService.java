package pl.shonsu.userhelpdesk.ticket.domain.service;

import org.springframework.stereotype.Component;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.Ticket;
import pl.shonsu.userhelpdesk.ticket.domain.port.in.RegisterTicketCommand;
import pl.shonsu.userhelpdesk.ticket.domain.port.in.RegisterTicketUseCase;
import pl.shonsu.userhelpdesk.ticket.domain.port.out.CreateTicketPort;

@Component
class RegisterTicketService implements RegisterTicketUseCase {
    private final CreateTicketPort createTicketPort;

    RegisterTicketService(CreateTicketPort createTicketPort) {
        this.createTicketPort = createTicketPort;
    }

    @Override
    public boolean registerTicket(RegisterTicketCommand registerTicketCommand) {
        Ticket ticket = Ticket.create(
                registerTicketCommand.creatorId(),
                registerTicketCommand.content()
        );
        createTicketPort.createTicket(ticket);
        return false;
    }
}

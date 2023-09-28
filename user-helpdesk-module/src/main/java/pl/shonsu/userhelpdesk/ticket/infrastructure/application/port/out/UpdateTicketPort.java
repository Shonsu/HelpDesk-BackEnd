package pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.out;

import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.Ticket;

public interface UpdateTicketPort {
    void updateTicket(Ticket ticket);
}

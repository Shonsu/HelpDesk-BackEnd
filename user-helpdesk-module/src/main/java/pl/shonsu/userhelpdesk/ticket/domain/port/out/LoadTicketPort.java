package pl.shonsu.userhelpdesk.ticket.domain.port.out;

import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.Ticket;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.TicketId;

public interface LoadTicketPort {
    Ticket loadTicket(TicketId ticketId);
}

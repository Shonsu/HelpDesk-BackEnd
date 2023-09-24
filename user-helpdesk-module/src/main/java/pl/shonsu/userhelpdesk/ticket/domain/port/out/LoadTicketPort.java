package pl.shonsu.userhelpdesk.ticket.domain.port.out;

import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.TicketId;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.TicketSnapshot;

public interface LoadTicketPort {
    TicketSnapshot loadTicket(TicketId ticketId);
}

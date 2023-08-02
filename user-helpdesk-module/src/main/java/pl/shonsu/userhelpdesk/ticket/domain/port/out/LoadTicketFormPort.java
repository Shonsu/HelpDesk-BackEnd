package pl.shonsu.userhelpdesk.ticket.domain.port.out;

import pl.shonsu.userhelpdesk.ticket.domain.model.ticketform.TicketForm;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticketform.TicketFormId;

public interface LoadTicketFormPort {
    TicketForm loadTicketForm(TicketFormId id);
}

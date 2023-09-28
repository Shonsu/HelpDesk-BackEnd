package pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.out;

import pl.shonsu.userhelpdesk.ticket.domain.model.ticketform.TicketForm;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticketform.TicketFormId;

public interface LoadTicketFormPort {
    TicketForm loadTicketForm(TicketFormId id);
}

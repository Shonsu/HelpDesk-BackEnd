package pl.shonsu.userhelpdesk.ticket.domain.model.ticketform;

import java.util.List;

public record TicketForm(TicketFormId id, List<TicketFormField> ticketFormFields) {
}

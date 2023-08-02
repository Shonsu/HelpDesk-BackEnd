package pl.shonsu.userhelpdesk.ticket.domain.model.ticket;

import pl.shonsu.userhelpdesk.ticket.domain.model.ticketform.TicketFormId;

import java.util.Map;

public record Content(TicketFormId id, Map<String, String> properties) {
}

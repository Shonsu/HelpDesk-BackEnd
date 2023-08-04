package pl.shonsu.userhelpdesk.ticket.domain.model.ticketform;

import java.util.List;

public record TicketFormField(String key, List<String> ticketFormFieldOption) {
}

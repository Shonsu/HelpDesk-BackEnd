package pl.shonsu.userhelpdesk.ticket.domain.model.ticket;

import java.util.Map;

public record Content(Long ticketFormId, Map<String, String> properties) {
}

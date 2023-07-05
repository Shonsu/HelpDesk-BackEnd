package pl.shonsu.userhelpdesk.domain.ticket;

import java.util.Map;

record Content(Long ticketFormId, Map<String, String> properties) {
}

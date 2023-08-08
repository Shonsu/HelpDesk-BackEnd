package pl.shonsu.userhelpdesk.ticket.infrastructure.application.web.dto;

import java.util.Map;

public record ContentResource(Long ticketFormId, Map<String, String> content) {
}

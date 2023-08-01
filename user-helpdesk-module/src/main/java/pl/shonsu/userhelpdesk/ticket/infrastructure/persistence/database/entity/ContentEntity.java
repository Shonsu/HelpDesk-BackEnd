package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.entity;

import java.util.Map;

public class ContentEntity {
    private Long ticketFormId;
    private Map<String, String> properties;

    public ContentEntity(Long ticketFormId, Map<String, String> properties) {
        this.ticketFormId = ticketFormId;
        this.properties = properties;
    }

    public Long getTicketFormId() {
        return ticketFormId;
    }

    public Map<String, String> getProperties() {
        return properties;
    }
}

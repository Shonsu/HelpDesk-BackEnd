package pl.shonsu.userhelpdesk.ticket.model;

import java.util.Map;

public class Content {
    private Long ticketFormId;
    private Map<String, String> properties;

    public Long getTicketFormId() {
        return ticketFormId;
    }

    public Map<String, String> getProperties() {
        return properties;
    }
}

package pl.shonsu.userhelpdesk.ticket.model;

import java.util.Map;

class Content {
    private Long ticketFormId;
    private Map<String, String> answers;

    public Long getTicketFormId() {
        return ticketFormId;
    }

    public Map<String, String> getAnswers() {
        return answers;
    }
}

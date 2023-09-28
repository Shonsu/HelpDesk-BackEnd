package pl.shonsu.userhelpdesk.ticket.domain.port.in;

import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.Content;

public interface TicketContentVerifier {
    void isTicketContentValid(Content content);
}

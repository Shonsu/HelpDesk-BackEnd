package pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in;

import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.Content;

public interface TicketContentVerifier {
    void isTicketContentValid(Content content);
}

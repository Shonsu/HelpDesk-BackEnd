package pl.shonsu.userhelpdesk.ticket.domain.service;

import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.Content;
import pl.shonsu.userhelpdesk.ticket.domain.port.in.TicketContentVerfifier;
import pl.shonsu.userhelpdesk.ticket.domain.port.out.LoadTicketFormPort;

public class TicketContentVerifierService implements TicketContentVerfifier {

    private final LoadTicketFormPort loadTicketFormPort;

    public TicketContentVerifierService(LoadTicketFormPort loadTicketFormPort) {
        this.loadTicketFormPort = loadTicketFormPort;
    }

    @Override
    public void isTicketContentValid(Content content) {
        loadTicketFormPort.loadTicketForm(content.id());
    }
}

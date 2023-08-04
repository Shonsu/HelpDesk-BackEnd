package pl.shonsu.userhelpdesk.ticket.domain.service;

import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.Content;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticketform.TicketForm;
import pl.shonsu.userhelpdesk.ticket.domain.port.in.TicketContentVerfifier;
import pl.shonsu.userhelpdesk.ticket.domain.port.out.LoadTicketFormPort;

public class TicketContentVerifierService implements TicketContentVerfifier {

    private final LoadTicketFormPort loadTicketFormPort;

    public TicketContentVerifierService(LoadTicketFormPort loadTicketFormPort) {
        this.loadTicketFormPort = loadTicketFormPort;
    }

    @Override
    public void isTicketContentValid(Content content) {
        TicketForm ticketForm = loadTicketFormPort.loadTicketForm(content.id());
        boolean valid = ticketForm.ticketFormFields().stream()
                .allMatch(ticketFormField ->
                        (content.properties().containsKey(ticketFormField.key()) && ticketFormField.ticketFormFieldOption().isEmpty())
                                || (!ticketFormField.ticketFormFieldOption().isEmpty() && (ticketFormField.ticketFormFieldOption().stream()
                                .anyMatch(fieldOptionValue -> content.properties().get(ticketFormField.key()).equals(fieldOptionValue)))));
        if (ticketForm.ticketFormFields().size() != content.properties().size() || !valid) {
            throw new IllegalArgumentException("Invalid ticket structure");
        }

    }
}

package pl.shonsu.userhelpdesk.ticket.domain.service;

import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.Content;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticketform.TicketForm;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticketform.TicketFormField;
import pl.shonsu.userhelpdesk.ticket.domain.port.in.TicketContentVerfifier;
import pl.shonsu.userhelpdesk.ticket.domain.port.out.LoadTicketFormPort;

import java.util.List;
import java.util.Map;

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
                        isEmpty(ticketFormField.ticketFormFieldOption()) ? isPropertiesContainsKey(content.properties(), ticketFormField.key()) : hasProperValueForTicketFormField(content.properties(), ticketFormField));
        if (ticketForm.ticketFormFields().size() != content.properties().size() || !valid) {
            throw new IllegalArgumentException("Invalid ticket structure");
        }
    }

    private static boolean isEmpty(List<String> ticketFormFieldOption) {
        return ticketFormFieldOption.isEmpty();
    }

    private static boolean isPropertiesContainsKey(Map<String, String> properties, String key) {
        return properties.containsKey(key);
    }

    private static boolean hasProperValueForTicketFormField(Map<String, String> properties, TicketFormField ticketFormField) {
        return ticketFormField.ticketFormFieldOption().stream()
                .anyMatch(fieldOptionValue -> properties.get(ticketFormField.key()).equals(fieldOptionValue));

    }
}

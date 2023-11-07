package pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in;

import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.TicketId;
import pl.shonsu.userhelpdesk.ticket.domain.model.user.UserId;

import java.util.List;

public interface TicketPresenterQuery {
    List<TicketViewResponse> getUserTickets(UserId userId);

    TicketViewResponse getById(TicketId ticketId);
}

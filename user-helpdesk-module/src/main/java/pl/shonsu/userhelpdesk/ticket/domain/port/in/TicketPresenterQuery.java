package pl.shonsu.userhelpdesk.ticket.domain.port.in;

import pl.shonsu.userhelpdesk.ticket.domain.model.user.UserId;

import java.util.List;

public interface TicketPresenterQuery {
    List<TicketViewResponse> getUserTickets(UserId userId);
}

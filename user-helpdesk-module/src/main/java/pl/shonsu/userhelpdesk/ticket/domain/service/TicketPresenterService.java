package pl.shonsu.userhelpdesk.ticket.domain.service;

import pl.shonsu.userhelpdesk.ticket.domain.model.user.UserId;
import pl.shonsu.userhelpdesk.ticket.domain.port.in.TicketPresenterQuery;
import pl.shonsu.userhelpdesk.ticket.domain.port.in.TicketViewResponse;

import java.util.List;

class TicketPresenterService implements TicketPresenterQuery {
    @Override
    public List<TicketViewResponse> getUserTickets(UserId userId) {
        return null;
    }
}

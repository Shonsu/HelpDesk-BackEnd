package pl.shonsu.userhelpdesk.ticket.infrastructure.application.service;

import pl.shonsu.userhelpdesk.ticket.domain.model.user.UserId;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.TicketPresenterQuery;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.TicketViewResponse;

import java.util.List;

class TicketPresenterService implements TicketPresenterQuery {
    @Override
    public List<TicketViewResponse> getUserTickets(UserId userId) {
        return null;
    }
}

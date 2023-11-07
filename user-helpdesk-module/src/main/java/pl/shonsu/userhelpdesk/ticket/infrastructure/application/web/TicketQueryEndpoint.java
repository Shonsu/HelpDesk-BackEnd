package pl.shonsu.userhelpdesk.ticket.infrastructure.application.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.TicketId;
import pl.shonsu.userhelpdesk.ticket.domain.model.user.UserId;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.TicketPresenterQuery;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.TicketViewResponse;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketQueryEndpoint {
    private final TicketPresenterQuery ticketPresenterQuery;

    public TicketQueryEndpoint(TicketPresenterQuery ticketPresenterQuery) {
        this.ticketPresenterQuery = ticketPresenterQuery;
    }

    @GetMapping()
    List<TicketViewResponse> listTickets(@AuthenticationPrincipal Long userId) {
        return ticketPresenterQuery.getUserTickets(UserId.of(userId));
    }

    @GetMapping("{ticketId}")
    TicketViewResponse getTicketById(@PathVariable Long ticketId) {
        return ticketPresenterQuery.getById(TicketId.of(ticketId));
    }
}

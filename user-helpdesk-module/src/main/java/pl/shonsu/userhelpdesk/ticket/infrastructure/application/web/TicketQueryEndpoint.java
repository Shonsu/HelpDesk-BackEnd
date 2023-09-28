package pl.shonsu.userhelpdesk.ticket.infrastructure.application.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.TicketViewResponse;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketQueryEndpoint {
    @GetMapping()
    List<TicketViewResponse> listTickets(@AuthenticationPrincipal Long userId){
        return null;
    }
}

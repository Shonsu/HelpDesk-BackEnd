package pl.shonsu.userhelpdesk.ticket.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.shonsu.userhelpdesk.ticket.controller.dto.TicketDtoRequest;
import pl.shonsu.userhelpdesk.ticket.controller.dto.TicketDtoResponse;
import pl.shonsu.userhelpdesk.ticket.service.TicketService;

@RestController
@RequestMapping("/helpdesk/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    TicketDtoResponse createTicket(@RequestBody TicketDtoRequest ticketDtoRequest,
                                   @AuthenticationPrincipal String username) {
        return ticketService.createTicket(ticketDtoRequest, username);
    }

}

package pl.shonsu.userhelpdesk.ticket.infrastructure.application.web;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import pl.shonsu.userhelpdesk.ticket.domain.model.creator.CreatorId;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.Content;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticketform.TicketFormId;
import pl.shonsu.userhelpdesk.ticket.domain.port.in.RegisterTicketCommand;
import pl.shonsu.userhelpdesk.ticket.domain.port.in.RegisterTicketUseCase;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.web.dto.ContentResource;
import pl.shonsu.userhelpdesk.ticket.domain.port.in.TicketViewResponse;

import java.util.List;

@RestController
@RequestMapping("/user")
class RegisterTicketController {
    private final RegisterTicketUseCase registerTicketUseCase;

    RegisterTicketController(RegisterTicketUseCase registerTicketUseCase) {
        this.registerTicketUseCase = registerTicketUseCase;
    }

    @PostMapping("/tickets/register")
    @ResponseStatus(HttpStatus.CREATED)
    void registerTicket(@Valid @RequestBody ContentResource contentResource, @AuthenticationPrincipal Long userId) {
        RegisterTicketCommand registerTicketCommand = new RegisterTicketCommand(
                CreatorId.of(userId),
                new Content(
                        TicketFormId.of(contentResource.ticketFormId()),
                        contentResource.content()));
        registerTicketUseCase.registerTicket(registerTicketCommand);
    }

    @GetMapping("/tickets")
    List<TicketViewResponse> listTickets(@AuthenticationPrincipal Long userId){
        return null;
    }
}

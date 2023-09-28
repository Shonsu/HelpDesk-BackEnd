package pl.shonsu.userhelpdesk.ticket.infrastructure.application.web;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import pl.shonsu.userhelpdesk.ticket.domain.model.creator.CreatorId;
import pl.shonsu.userhelpdesk.ticket.domain.model.operator.OperatorId;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.Content;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.TicketId;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticketform.TicketFormId;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.OpenTicketCommand;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.OpenTicketUseCase;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.RegisterTicketCommand;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.RegisterTicketUseCase;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.web.dto.ContentResource;

@RestController
@RequestMapping("/tickets/commands")
class TicketCommandEndpoint {
    private final RegisterTicketUseCase registerTicketUseCase;

    private final OpenTicketUseCase openTicketUseCase;

    TicketCommandEndpoint(RegisterTicketUseCase registerTicketUseCase, OpenTicketUseCase openTicketUseCase) {
        this.registerTicketUseCase = registerTicketUseCase;
        this.openTicketUseCase = openTicketUseCase;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    void registerTicket(@Valid @RequestBody ContentResource contentResource, @AuthenticationPrincipal Long userId) {
        RegisterTicketCommand registerTicketCommand = new RegisterTicketCommand(
                CreatorId.of(userId),
                new Content(
                        TicketFormId.of(contentResource.ticketFormId()),
                        contentResource.content()));
        registerTicketUseCase.registerTicket(registerTicketCommand);
    }

    @PostMapping("/open/{id}")
    void openTicket(@PathVariable Long id, @AuthenticationPrincipal Long principal) {
        OpenTicketCommand command = new OpenTicketCommand(TicketId.of(id), OperatorId.of(principal));
        openTicketUseCase.openTicket(command);
    }

}

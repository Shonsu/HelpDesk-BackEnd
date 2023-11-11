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
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.*;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.commands.CancelTicketCommand;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.commands.CloseTicketCommand;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.commands.OpenTicketCommand;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.commands.RegisterTicketCommand;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.web.dto.ContentResource;

@RestController
@RequestMapping("/tickets/commands")
class TicketCommandEndpoint {
    private final RegisterTicketUseCase registerTicketUseCase;
    private final OpenTicketUseCase openTicketUseCase;
    private final CloseTicketUseCase closeTicketUseCase;
    private final CancelTicketUseCase cancelTicketUseCase;

    TicketCommandEndpoint(RegisterTicketUseCase registerTicketUseCase, OpenTicketUseCase openTicketUseCase, CloseTicketUseCase closeTicketUseCase, CancelTicketUseCase cancelTicketUseCase) {
        this.registerTicketUseCase = registerTicketUseCase;
        this.openTicketUseCase = openTicketUseCase;
        this.closeTicketUseCase = closeTicketUseCase;
        this.cancelTicketUseCase = cancelTicketUseCase;
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

    @PostMapping("/close/{id}")
    void closeTicket(@PathVariable Long id, @AuthenticationPrincipal Long principal, @RequestBody String description) {
        CloseTicketCommand command = new CloseTicketCommand(TicketId.of(id), OperatorId.of(principal), description);
        closeTicketUseCase.closeTicket(command);
    }

    @PostMapping("/cancel/{id}")
    void cancelTicket(@PathVariable Long id, @AuthenticationPrincipal Long principal, @RequestBody String description) {
        CancelTicketCommand command = new CancelTicketCommand(TicketId.of(id), CreatorId.of(principal), description);
        cancelTicketUseCase.cancelTicket(command);
    }
}

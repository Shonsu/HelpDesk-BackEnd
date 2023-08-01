package pl.shonsu.userhelpdesk.ticket.domain.adapter.in.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.shonsu.userhelpdesk.ticket.domain.port.in.RegisterTicketCommand;
import pl.shonsu.userhelpdesk.ticket.domain.port.in.RegisterTicketUseCase;

@RestController
class RegisterTicketController {
    private final RegisterTicketUseCase registerTicketUseCase;

    RegisterTicketController(RegisterTicketUseCase registerTicketUseCase) {
        this.registerTicketUseCase = registerTicketUseCase;
    }

    @PostMapping("/ticket/register")
    @ResponseStatus(HttpStatus.CREATED)
    void registerTicket(@RequestBody RegisterTicketCommand command){
        registerTicketUseCase.registerTicket(command);
    }
}

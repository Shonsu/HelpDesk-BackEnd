package pl.shonsu.userhelpdesk.ticket.infrastructure.application.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.CancelTicketUseCase;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.CloseTicketUseCase;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.OpenTicketUseCase;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.RegisterTicketUseCase;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.out.CreateTicketPort;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.out.LoadTicketFormPort;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.out.LoadTicketPort;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.out.UpdateTicketPort;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.service.*;

@Configuration
class TicketWebConfig {

    private final LoadTicketPort loadTicketPort;
    private final UpdateTicketPort updateTicketPort;

    TicketWebConfig(LoadTicketPort loadTicketPort, UpdateTicketPort updateTicketPort) {
        this.loadTicketPort = loadTicketPort;
        this.updateTicketPort = updateTicketPort;
    }

    @Bean
    RegisterTicketUseCase registerTicketUseCase(CreateTicketPort createTicketPort, LoadTicketFormPort loadTicketFormPort) {
        return new RegisterTicketService(createTicketPort, new TicketContentVerifierService(loadTicketFormPort));
    }

    @Bean
    OpenTicketUseCase openTicketUseCase() {
        return new OpenTicketService(loadTicketPort, updateTicketPort);
    }

    @Bean
    CloseTicketUseCase closeTicketUseCase() {
        return new CloseTicketService(loadTicketPort, updateTicketPort);
    }

    @Bean
    CancelTicketUseCase cancelTicketUseCase() {
        return new CancelTicketService(loadTicketPort, updateTicketPort);
    }
}

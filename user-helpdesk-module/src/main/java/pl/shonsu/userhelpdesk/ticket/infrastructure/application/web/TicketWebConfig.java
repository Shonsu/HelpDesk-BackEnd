package pl.shonsu.userhelpdesk.ticket.infrastructure.application.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.shonsu.userhelpdesk.ticket.domain.port.in.RegisterTicketUseCase;
import pl.shonsu.userhelpdesk.ticket.domain.port.out.CreateTicketPort;
import pl.shonsu.userhelpdesk.ticket.domain.port.out.LoadTicketFormPort;
import pl.shonsu.userhelpdesk.ticket.domain.service.RegisterTicketService;
import pl.shonsu.userhelpdesk.ticket.domain.service.TicketContentVerifierService;

@Configuration
class TicketWebConfig {
    @Bean
    RegisterTicketUseCase registerTicketUseCase(CreateTicketPort createTicketPort, LoadTicketFormPort loadTicketFormPort) {
        return new RegisterTicketService(createTicketPort, new TicketContentVerifierService(loadTicketFormPort));
    }
}

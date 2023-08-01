package pl.shonsu.userhelpdesk.ticket.infrastructure.application.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.shonsu.userhelpdesk.ticket.domain.port.in.RegisterTicketUseCase;
import pl.shonsu.userhelpdesk.ticket.domain.port.out.CreateTicketPort;
import pl.shonsu.userhelpdesk.ticket.domain.service.RegisterTicketService;

@Configuration
class TicketWebConfig {
    @Bean
    RegisterTicketUseCase registerTicketUseCase(CreateTicketPort createTicketPort){
        return new RegisterTicketService(createTicketPort);
    }
}

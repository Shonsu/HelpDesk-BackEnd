package pl.shonsu.userhelpdesk.ticket.infrastructure.application.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.OpenTicketUseCase;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.RegisterTicketUseCase;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.out.CreateTicketPort;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.out.LoadTicketFormPort;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.out.LoadTicketPort;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.out.UpdateTicketPort;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.service.OpenTicketService;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.service.RegisterTicketService;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.service.TicketContentVerifierService;

@Configuration
class TicketWebConfig {
    @Bean
    RegisterTicketUseCase registerTicketUseCase(CreateTicketPort createTicketPort, LoadTicketFormPort loadTicketFormPort) {
        return new RegisterTicketService(createTicketPort, new TicketContentVerifierService(loadTicketFormPort));
    }

    @Bean
    OpenTicketUseCase openTicketUseCase(LoadTicketPort loadTicketPort, UpdateTicketPort updateTicketPort){
        return new OpenTicketService(loadTicketPort, updateTicketPort);
    }

}

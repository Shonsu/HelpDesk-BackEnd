package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.out.CreateTicketPort;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.out.LoadTicketPort;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.out.UpdateTicketPort;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.repository.TicketEntityRepository;

@Configuration
class TicketPersistenceConfig {
    private final TicketEntityRepository ticketEntityRepository;

    TicketPersistenceConfig(TicketEntityRepository ticketEntityRepository) {
        this.ticketEntityRepository = ticketEntityRepository;
    }

    @Bean
    CreateTicketPort createTicketPort() {
        return new TicketPersistenceAdapter(ticketEntityRepository);
    }

    @Bean
    UpdateTicketPort updateTicketPort() {
        return new TicketPersistenceAdapter(ticketEntityRepository);
    }

    @Bean
    LoadTicketPort loadTicketPort() {
        return new TicketPersistenceAdapter(ticketEntityRepository);
    }
}

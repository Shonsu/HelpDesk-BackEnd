package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.repository.TicketEntityRepository;
import pl.shonsu.userhelpdesk.ticket.domain.port.out.CreateTicketPort;

@Configuration
class TicketPersistenceConfig {
    @Bean
    CreateTicketPort createTicketPort(TicketEntityRepository ticketEntityRepository) {
        return new TicketPersistenceAdapter(ticketEntityRepository);
    }
}

package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticketform;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.shonsu.userhelpdesk.ticket.domain.port.out.LoadTicketFormPort;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticketform.repository.TicketFormEntityRepository;

@Configuration
class TicketFormPersistenceConfig {
    @Bean
    LoadTicketFormPort loadTicketFormPort(TicketFormEntityRepository ticketFormEntityRepository) {
        return new TicketFormPersistenceAdapter(ticketFormEntityRepository);
    }
}

package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.out.LoadTicketPort;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.out.UpdateTicketPort;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.repository.TicketEntityRepository;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.out.CreateTicketPort;

@Configuration
class TicketPersistenceConfig {
    @Bean
    CreateTicketPort createTicketPort(TicketEntityRepository ticketEntityRepository) {
        return new TicketPersistenceAdapter(ticketEntityRepository);
    }
    @Bean
    UpdateTicketPort updateTicketPort(TicketEntityRepository ticketEntityRepository){
        return new TicketPersistenceAdapter(ticketEntityRepository);
    }

    @Bean
    LoadTicketPort loadTicketPort(TicketEntityRepository ticketEntityRepository){
        return new TicketPersistenceAdapter(ticketEntityRepository);
    }
}

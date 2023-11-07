package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticketsubcategory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.TicketPresenterQuery;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.service.TicketPresenterService;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.repository.TicketEntityRepository;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticketform.repository.TicketFormEntityRepository;

@Configuration
public class TicketSubCategoryPersistenceConfig {
    @Bean
    TicketPresenterQuery ticketPresenterQuery(TicketSubCategoryEntityRepository ticketSubCategoryEntityRepository, TicketEntityRepository ticketEntityRepository, TicketFormEntityRepository ticketFormEntityRepository) {
        return new TicketPresenterService(ticketSubCategoryEntityRepository, ticketEntityRepository, ticketFormEntityRepository);
    }
}

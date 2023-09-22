package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticketform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticketform.entity.TicketFormEntity;

public interface TicketFormEntityRepository extends JpaRepository<TicketFormEntity, Long> {
}

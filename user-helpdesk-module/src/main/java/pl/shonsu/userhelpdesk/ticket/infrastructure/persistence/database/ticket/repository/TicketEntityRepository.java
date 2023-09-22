package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.entity.TicketEntity;

public interface TicketEntityRepository extends JpaRepository<TicketEntity, Long> {
}

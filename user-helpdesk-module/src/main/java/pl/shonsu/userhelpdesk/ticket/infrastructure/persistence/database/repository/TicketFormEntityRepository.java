package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.entity.TicketFormEntity;

public interface TicketFormEntityRepository extends JpaRepository<TicketFormEntity, Long> {
}

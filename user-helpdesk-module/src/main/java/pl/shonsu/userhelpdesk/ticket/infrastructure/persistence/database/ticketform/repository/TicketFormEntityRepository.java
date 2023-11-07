package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticketform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticketform.entity.TicketFormEntity;

import java.util.Collection;
import java.util.List;

public interface TicketFormEntityRepository extends JpaRepository<TicketFormEntity, Long> {
    List<TicketFormEntity> findByIdIn(Collection<Long> list);
}

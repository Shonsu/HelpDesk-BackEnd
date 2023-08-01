package pl.shonsu.userhelpdesk.ticket.domain.adapter.out.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shonsu.userhelpdesk.ticket.domain.adapter.out.persistance.entity.TicketEntity;

public interface TicketEntityRepository extends JpaRepository<TicketEntity, Long> {
}

package pl.shonsu.userhelpdesk.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shonsu.userhelpdesk.ticket.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}

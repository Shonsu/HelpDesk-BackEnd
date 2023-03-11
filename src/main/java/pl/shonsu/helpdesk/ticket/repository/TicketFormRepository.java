package pl.shonsu.helpdesk.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shonsu.helpdesk.ticket.model.TicketForm;

public interface TicketFormRepository extends JpaRepository<TicketForm, Long> {

}

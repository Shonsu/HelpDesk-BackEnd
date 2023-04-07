package pl.shonsu.helpdesk.management.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shonsu.helpdesk.management.ticket.controller.dto.TicketFormNameDto;
import pl.shonsu.helpdesk.management.ticket.model.TicketForm;

import java.util.List;

public interface TicketFormRepository extends JpaRepository<TicketForm, Long> {
    List<TicketFormNameDto> findAllBy();
}

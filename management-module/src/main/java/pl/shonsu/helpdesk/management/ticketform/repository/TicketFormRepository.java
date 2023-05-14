package pl.shonsu.helpdesk.management.ticketform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shonsu.helpdesk.management.ticketform.controller.dto.TicketFormNameDto;
import pl.shonsu.helpdesk.management.ticketform.model.TicketForm;

import java.util.List;

public interface TicketFormRepository extends JpaRepository<TicketForm, Long> {
    List<TicketFormNameDto> findAllBy();
}

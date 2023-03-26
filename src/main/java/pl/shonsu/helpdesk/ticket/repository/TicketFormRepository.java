package pl.shonsu.helpdesk.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shonsu.helpdesk.ticket.controller.dto.TicketFormNameDto;
import pl.shonsu.helpdesk.ticket.model.TicketForm;

import java.util.List;

public interface TicketFormRepository extends JpaRepository<TicketForm, Long> {

    List<TicketFormNameDto> findAllBy();
}

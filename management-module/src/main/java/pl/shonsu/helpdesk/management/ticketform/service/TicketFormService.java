package pl.shonsu.helpdesk.management.ticketform.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.shonsu.helpdesk.management.ticketform.controller.dto.TicketFormNameDto;
import pl.shonsu.helpdesk.management.ticketform.model.TicketForm;
import pl.shonsu.helpdesk.management.ticketform.repository.TicketFormRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public
class TicketFormService {
    private final TicketFormRepository ticketFormRepository;

    @Transactional
    public TicketForm createTicketForm(TicketForm ticketForm) {
        return ticketFormRepository.save(ticketForm);
    }

    public TicketForm getTicketForm(Long id) {
        return ticketFormRepository.findById(id).orElseThrow();
    }

    public List<TicketFormNameDto> getTicketFormsView() {
        return ticketFormRepository.findAllBy();
    }

    public void deleteTicketForm(Long id) {
        ticketFormRepository.deleteById(id);
    }

    public TicketForm updateTicketForm(TicketForm ticketForm) {
        return ticketFormRepository.save(ticketForm);
    }
}

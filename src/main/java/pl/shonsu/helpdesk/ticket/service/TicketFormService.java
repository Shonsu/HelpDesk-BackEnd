package pl.shonsu.helpdesk.ticket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.shonsu.helpdesk.ticket.model.TicketForm;
import pl.shonsu.helpdesk.ticket.repository.TicketFormRepository;

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
}

package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database;

import pl.shonsu.userhelpdesk.ticket.domain.model.ticketform.TicketForm;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticketform.TicketFormId;
import pl.shonsu.userhelpdesk.ticket.domain.port.out.LoadTicketFormPort;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.entity.TicketFormEntity;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.repository.TicketFormEntityRepository;

public class TicketFormPersistenceAdapter implements LoadTicketFormPort {

    private final TicketFormEntityRepository ticketFormEntityRepository;

    TicketFormPersistenceAdapter(TicketFormEntityRepository ticketFormEntityRepository) {
        this.ticketFormEntityRepository = ticketFormEntityRepository;
    }

    @Override
    public TicketForm loadTicketForm(TicketFormId id) {
        TicketFormEntity ticketFormEntity = ticketFormEntityRepository.findById(id.id()).orElseThrow();
        //TODO Mapping to domain object
        return null;
    }
}

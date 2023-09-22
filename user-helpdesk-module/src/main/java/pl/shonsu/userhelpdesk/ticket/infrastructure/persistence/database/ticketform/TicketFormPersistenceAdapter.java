package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticketform;

import jakarta.persistence.EntityNotFoundException;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticketform.TicketForm;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticketform.TicketFormField;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticketform.TicketFormId;
import pl.shonsu.userhelpdesk.ticket.domain.port.out.LoadTicketFormPort;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticketform.entity.TicketFormEntity;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticketform.entity.TicketFormFieldEntity;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticketform.entity.TicketFormFieldOptionEntity;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticketform.repository.TicketFormEntityRepository;

import java.text.MessageFormat;
import java.util.List;

public class TicketFormPersistenceAdapter implements LoadTicketFormPort {

    private final TicketFormEntityRepository ticketFormEntityRepository;

    TicketFormPersistenceAdapter(TicketFormEntityRepository ticketFormEntityRepository) {
        this.ticketFormEntityRepository = ticketFormEntityRepository;
    }

    @Override
    public TicketForm loadTicketForm(TicketFormId id) {
        TicketFormEntity ticketFormEntity = ticketFormEntityRepository.findById(id.id())
                .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format("Not found TickeForm with id: {0}", id.id())));

        return new TicketForm(
                new TicketFormId(ticketFormEntity.getId()),
                mapToTicketFormFields(ticketFormEntity));

    }

    private static List<TicketFormField> mapToTicketFormFields(TicketFormEntity ticketFormEntity) {
        return ticketFormEntity.getTicketFormFieldEntities().stream()
                .map(TicketFormPersistenceAdapter::mapToTicketFormField).toList();
    }

    private static TicketFormField mapToTicketFormField(TicketFormFieldEntity ticketFormFieldEntity) {
        return new TicketFormField(
                ticketFormFieldEntity.getKey(),
                ticketFormFieldEntity.getTicketFormFieldOptionEntities().stream()
                        .map(TicketFormFieldOptionEntity::getKey).toList());
    }
}

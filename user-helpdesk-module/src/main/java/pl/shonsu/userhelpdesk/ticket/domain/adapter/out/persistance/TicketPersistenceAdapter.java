package pl.shonsu.userhelpdesk.ticket.domain.adapter.out.persistance;

import pl.shonsu.userhelpdesk.ticket.domain.adapter.out.persistance.entity.ActionEntity;
import pl.shonsu.userhelpdesk.ticket.domain.adapter.out.persistance.entity.ContentEntity;
import pl.shonsu.userhelpdesk.ticket.domain.adapter.out.persistance.entity.Status;
import pl.shonsu.userhelpdesk.ticket.domain.adapter.out.persistance.entity.TicketEntity;
import pl.shonsu.userhelpdesk.ticket.domain.adapter.out.persistance.repository.TicketEntityRepository;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.Action;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.Ticket;
import pl.shonsu.userhelpdesk.ticket.domain.port.out.CreateTicketPort;

import java.util.List;

public class TicketPersistenceAdapter implements CreateTicketPort {
    private final TicketEntityRepository ticketEntityRepository;

    public TicketPersistenceAdapter(TicketEntityRepository ticketEntityRepository) {
        this.ticketEntityRepository = ticketEntityRepository;
    }

    @Override
    public void createTicket(Ticket ticket) {
        TicketEntity ticketEntity = mapToTicketEntity(ticket);
        ticketEntityRepository.save(ticketEntity);
    }

    private static TicketEntity mapToTicketEntity(Ticket ticket) {

        List<ActionEntity> actionsEntity = ticket.getActionHistory()
                .getActions()
                .stream()
                .map(TicketPersistenceAdapter::mapToActionEntity).toList();

        ContentEntity contentEntity = new ContentEntity(
                ticket.getContent().ticketFormId(),
                ticket.getContent().properties()
        );

        return new TicketEntity(
                ticket.getTicketId() == null ? null : ticket.getTicketId().id(),
                ticket.getCreatorId().id(),
                ticket.getCreateAt().time(),
                ticket.getExpiryAt().time(),
                contentEntity,
                Status.valueOf(ticket.getCurrentStatus().name()),
                actionsEntity
        );
    }

    private static ActionEntity mapToActionEntity(Action action) {
        return ActionEntity.withoutId(
                action.who().id(),
                Status.valueOf(action.what().name()),
                action.description(),
                action.timestamp(),
                null);
    }
}

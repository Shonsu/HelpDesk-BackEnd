package pl.shonsu.userhelpdesk.ticket.domain.adapter.out.persistance;

import org.springframework.stereotype.Component;
import pl.shonsu.userhelpdesk.ticket.domain.adapter.out.persistance.entity.ActionEntity;
import pl.shonsu.userhelpdesk.ticket.domain.adapter.out.persistance.entity.ContentEntity;
import pl.shonsu.userhelpdesk.ticket.domain.adapter.out.persistance.entity.Status;
import pl.shonsu.userhelpdesk.ticket.domain.adapter.out.persistance.entity.TicketEntity;
import pl.shonsu.userhelpdesk.ticket.domain.adapter.out.persistance.repository.TicketEntityRepository;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.Action;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.Ticket;
import pl.shonsu.userhelpdesk.ticket.domain.port.out.CreateTicketPort;

import java.util.ArrayList;
import java.util.List;

@Component
class TicketPersistenceAdapter implements CreateTicketPort {
    private final TicketEntityRepository ticketEntityRepository;

    TicketPersistenceAdapter(TicketEntityRepository ticketEntityRepository) {
        this.ticketEntityRepository = ticketEntityRepository;
    }

    @Override
    public void createTicket(Ticket ticket) {
        TicketEntity ticketEntity = mapToTicketEntity(ticket);
        ticketEntityRepository.save(ticketEntity);
    }

    private static TicketEntity mapToTicketEntity(Ticket ticket) {

        List<ActionEntity> actionsEntity = new ArrayList<>();
        ticket.getActionHistory().getActions().forEach(TicketPersistenceAdapter::mapToActionEntity);

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
        return new ActionEntity(
                action.actionId() == null ? null : action.actionId().id(),
                Status.valueOf(action.what().name()),
                action.description(),
                action.timestamp());
    }
}

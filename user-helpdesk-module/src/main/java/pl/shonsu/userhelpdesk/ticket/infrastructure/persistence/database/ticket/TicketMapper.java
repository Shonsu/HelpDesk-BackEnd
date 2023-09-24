package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket;

import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.Action;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.Ticket;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.entity.ActionEntity;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.entity.ContentEntity;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.entity.Status;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.entity.TicketEntity;

import java.util.List;

public class TicketMapper {
    public static TicketEntity mapToTicketEntity(Ticket ticket) {

        List<ActionEntity> actionsEntity = ticket.getActionHistory()
                .getActions()
                .stream()
                .map(TicketMapper::mapToActionEntity).toList();

        ContentEntity contentEntity = new ContentEntity(
                ticket.getContent().id().id(),
                ticket.getContent().properties()
        );

        return new TicketEntity(
                ticket.getTicketId() == null ? null : ticket.getTicketId().id(),
                ticket.getCreatorId().id(),
                ticket.getOperatorId().id(),
                ticket.getCreateAt().time(),
                ticket.getOpenedAt().time(),
                ticket.getTerminatedAt().time(),
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

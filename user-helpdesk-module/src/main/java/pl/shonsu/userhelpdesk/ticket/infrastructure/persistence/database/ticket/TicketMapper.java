package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket;

import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.Action;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.Ticket;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.TicketSnapshot;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.entity.ActionEntity;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.entity.ContentEntity;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.entity.Status;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.entity.TicketEntity;

import java.util.List;

public class TicketMapper {
    public static TicketEntity mapToTicketEntity(Ticket ticket) {
        TicketSnapshot ticketSnapshot = ticket.snapshot();
        List<ActionEntity> actionsEntity = ticketSnapshot.actionHistory()
                .getActions()
                .stream()
                .map(TicketMapper::mapToActionEntity).toList();

        ContentEntity contentEntity = new ContentEntity(
                ticketSnapshot.content().id().id(),
                ticketSnapshot.content().properties()
        );

        return new TicketEntity(
                ticketSnapshot.ticketId() == null ? null : ticketSnapshot.ticketId().id(),
                ticketSnapshot.creatorIdToNullableLong(),
                ticketSnapshot.operatorIdToNullableLong(),
                ticketSnapshot.createAt().time(),
                ticketSnapshot.openedAtToNullableLong(),
                ticketSnapshot.terminatedAtToNullableLong(),
                ticketSnapshot.expiryAtToNullableLong(),
                contentEntity,
                Status.valueOf(ticketSnapshot.status().name()),
                actionsEntity
        );
    }

    private static ActionEntity mapToActionEntity(Action action) {
        return new ActionEntity(
                action.actionId() == null ? null : action.actionId().id(),
                action.who().id(),
                Status.valueOf(action.what().name()),
                action.description(),
                action.timestamp(),
                action.ticketId() == null ? null : action.ticketId().id()
                );
    }
}

package pl.shonsu.userhelpdesk.ticket.domain.model.ticket;

import pl.shonsu.userhelpdesk.ticket.domain.model.operator.OperatorId;
import pl.shonsu.userhelpdesk.ticket.domain.model.user.UserId;

import java.time.Instant;

public final class OpenedTicket extends Ticket {
    public OpenedTicket(NewTicket ticket, OperatorId operatorId, Status open, OpenedAt openedAt) {
        super(ticket, operatorId, open, openedAt);
    }

    public OpenedTicket(TicketSnapshot ticketSnapshot) {
        super(ticketSnapshot);
    }

    public ClosedTicket close(OperatorId operatorId, String description) {
        addActionToHistory(UserId.of(operatorId.id()), description);
        return new ClosedTicket(this, operatorId, Status.CLOSED);
    }

    public CanceledTicket cancel() {
        addActionToHistory(UserId.of(creatorId.id()), null);
        return new CanceledTicket(this, Status.CANCELED);
    }

    public RejectedTicket reject(OperatorId operatorId, String description) {
        addActionToHistory(UserId.of(operatorId.id()), description);
        return new RejectedTicket(this, operatorId, Status.REJECTED);
    }

    private void addActionToHistory(UserId userId, String description) {
        Action action = new Action(UserId.of(userId.id()), Status.CLOSED, Instant.now(), description);
        actionHistory.addAction(action);
    }
}

package pl.shonsu.userhelpdesk.ticket.domain.model.ticket;

import pl.shonsu.userhelpdesk.ticket.domain.model.creator.CreatorId;
import pl.shonsu.userhelpdesk.ticket.domain.model.operator.OperatorId;
import pl.shonsu.userhelpdesk.ticket.domain.model.user.UserId;

import java.time.Instant;

public final class NewTicket extends Ticket {
    NewTicket(CreatorId creatorId, Content content) {
        super(creatorId, content, Status.NEW, new ActionHistory());
        addActionToHistory(UserId.of(creatorId.id()), Status.NEW);
    }

    public NewTicket(TicketSnapshot ticketSnapshot) {
        super(ticketSnapshot);
    }

    public Ticket open(OperatorId operatorId) {
        addActionToHistory(UserId.of(operatorId.id()), Status.OPEN);
        return new OpenedTicket(this, operatorId, Status.OPEN, OpenedAt.of(Instant.now()));
    }
    public CanceledTicket cancel() {
        addActionToHistory(UserId.of(creatorId.id()), Status.CANCELED);
        return new CanceledTicket(this, Status.CANCELED);
    }
    private void addActionToHistory(UserId userId, Status status) {
        Action action = new Action(userId, status, Instant.now());
        actionHistory.addAction(action);
    }
}

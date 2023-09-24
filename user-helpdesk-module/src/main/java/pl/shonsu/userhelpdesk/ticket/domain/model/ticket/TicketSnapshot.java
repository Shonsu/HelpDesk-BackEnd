package pl.shonsu.userhelpdesk.ticket.domain.model.ticket;

import pl.shonsu.userhelpdesk.ticket.domain.model.creator.CreatorId;
import pl.shonsu.userhelpdesk.ticket.domain.model.operator.OperatorId;

public record TicketSnapshot(
        TicketId ticketId,
        CreatorId creatorId,
        OperatorId operatorId,
        CreatedAt createAt,
        OpenedAt openedAt,
        TerminatedAt terminatedAt,
        ExpiryAt expiryAt,
        Content content,
        Status status
) {
    public enum Status {
        NEW, OPEN, CLOSED, REJECTED, CANCELED;
    }
}

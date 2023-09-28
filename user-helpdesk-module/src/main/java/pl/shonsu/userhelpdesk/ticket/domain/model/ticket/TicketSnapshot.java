package pl.shonsu.userhelpdesk.ticket.domain.model.ticket;

import pl.shonsu.userhelpdesk.ticket.domain.model.creator.CreatorId;
import pl.shonsu.userhelpdesk.ticket.domain.model.operator.OperatorId;

import java.time.Instant;

public record TicketSnapshot(
        TicketId ticketId,
        CreatorId creatorId,
        OperatorId operatorId,
        CreatedAt createAt,
        OpenedAt openedAt,
        TerminatedAt terminatedAt,
        ExpiryAt expiryAt,
        Content content,
        Status status,
        ActionHistory actionHistory
) {

    public Long creatorIdToNullableLong() {
        return creatorId != null ? creatorId.id() : null;
    }
    public Long operatorIdToNullableLong() {
        return operatorId != null ? operatorId.id() : null;
    }
    public Instant openedAtToNullableLong() {
        return openedAt != null ? openedAt.time() : null;
    }
    public Instant terminatedAtToNullableLong() {
        return terminatedAt != null ? terminatedAt.time() : null;
    }
    public Instant expiryAtToNullableLong() {
        return expiryAt != null ? expiryAt.time() : null;
    }
    public enum Status {
        NEW, OPEN, CLOSED, REJECTED, CANCELED
    }
}

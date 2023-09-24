package pl.shonsu.userhelpdesk.ticket.domain.model.ticket;

import pl.shonsu.userhelpdesk.ticket.domain.model.creator.CreatorId;
import pl.shonsu.userhelpdesk.ticket.domain.model.operator.OperatorId;

import java.time.Instant;
import java.time.Period;

abstract sealed class TicketV2 permits NewTicket, CanceledTicket, OpenedTicket, RejectedTicket, ClosedTicket {

    protected final TicketId ticketId;
    protected final OperatorId operatorId;
    protected final CreatorId creatorId;
    protected final CreatedAt createAt;
    protected final OpenedAt openedAt;
    protected final TerminatedAt terminatedAt;
    protected final ExpiryAt expiryAt;
    protected final Content content;

    protected final Status status;

    private TicketV2(TicketId ticketId, OperatorId operatorId, CreatorId creatorId, CreatedAt createAt, OpenedAt openedAt, TerminatedAt terminatedAt, ExpiryAt expiryAt, Content content, Status status) {
        this.ticketId = ticketId;
        this.operatorId = operatorId;
        this.creatorId = creatorId;
        this.createAt = createAt;
        this.openedAt = openedAt;
        this.terminatedAt = terminatedAt;
        this.expiryAt = expiryAt;
        this.content = content;
        this.status = status;
    }

    TicketV2(CreatorId creatorId, Content content, Status status) {
        this(
                null,
                null,
                creatorId,
                CreatedAt.of(Instant.now()),
                null,
                null,
                null,
                content,
                status);
    }

    TicketV2(NewTicket ticket, OperatorId operatorId, Status status) {
        this(
                ticket.ticketId,
                operatorId,
                ticket.creatorId,
                ticket.createAt,
                ticket.openedAt,
                null,
                ExpiryAt.of(Instant.now().plus(Period.ofDays(3))),
                ticket.content,
                status);
    }

    TicketV2(OpenedTicket ticket, OperatorId operatorId, Status status) {
        this(
                ticket.ticketId,
                operatorId,
                ticket.creatorId,
                ticket.createAt,
                ticket.openedAt,
                TerminatedAt.of(Instant.now()),
                ticket.expiryAt,
                ticket.content,
                status);
    }

    TicketV2(OpenedTicket ticket, Status status) {
        this(
                ticket.ticketId,
                ticket.operatorId,
                ticket.creatorId,
                ticket.createAt,
                ticket.openedAt,
                TerminatedAt.of(Instant.now()),
                ticket.expiryAt,
                ticket.content,
                status);
    }

    public TicketV2(TicketSnapshot ticketSnapshot) {
        this(
                ticketSnapshot.ticketId(),
                ticketSnapshot.operatorId(),
                ticketSnapshot.creatorId(),
                ticketSnapshot.createAt(),
                ticketSnapshot.openedAt(),
                ticketSnapshot.terminatedAt(),
                ticketSnapshot.expiryAt(),
                ticketSnapshot.content(),
                Status.valueOf(ticketSnapshot.status().name())
        );
    }


    static TicketV2 create(CreatorId creatorId, Content content) {
        return new NewTicket(creatorId, content);
    }

    public static TicketV2 from(TicketSnapshot ticketSnapshot) {
        return switch (ticketSnapshot.status()) {
            case NEW -> new NewTicket(ticketSnapshot);
            case OPEN -> new OpenedTicket(ticketSnapshot);
            case CLOSED -> new ClosedTicket(ticketSnapshot);
            case REJECTED -> new RejectedTicket(ticketSnapshot);
            case CANCELED -> new CanceledTicket(ticketSnapshot);
        };
    }

    public enum Status {
        NEW, OPEN, CLOSED, REJECTED, CANCELED;
    }
}

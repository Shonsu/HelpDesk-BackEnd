package pl.shonsu.userhelpdesk.ticket.domain.model.ticket;

import lombok.Getter;
import pl.shonsu.userhelpdesk.ticket.domain.model.creator.CreatorId;
import pl.shonsu.userhelpdesk.ticket.domain.model.operator.OperatorId;

import java.time.Instant;
import java.time.Period;

@Getter
public abstract sealed class Ticket permits NewTicket, CanceledTicket, OpenedTicket, RejectedTicket, ClosedTicket {

    protected final TicketId ticketId;
    protected final OperatorId operatorId;
    protected final CreatorId creatorId;
    protected final CreatedAt createAt;
    protected final OpenedAt openedAt;
    protected final TerminatedAt terminatedAt;
    protected final ExpiryAt expiryAt;
    protected final Content content;

    protected final Status status;

    protected final ActionHistory actionHistory;

    private Ticket(TicketId ticketId, OperatorId operatorId, CreatorId creatorId, CreatedAt createAt, OpenedAt openedAt, TerminatedAt terminatedAt, ExpiryAt expiryAt, Content content, Status status, ActionHistory actionHistory) {
        this.ticketId = ticketId;
        this.operatorId = operatorId;
        this.creatorId = creatorId;
        this.createAt = createAt;
        this.openedAt = openedAt;
        this.terminatedAt = terminatedAt;
        this.expiryAt = expiryAt;
        this.content = content;
        this.status = status;
        this.actionHistory = actionHistory;
    }

    Ticket(CreatorId creatorId, Content content, Status status, ActionHistory actionHistory) {
        this(
                null,
                null,
                creatorId,
                CreatedAt.of(Instant.now()),
                null,
                null,
                null,
                content,
                status,
                actionHistory);
    }

    Ticket(NewTicket ticket, OperatorId operatorId, Status status, OpenedAt openedAt) {
        this(
                ticket.ticketId,
                operatorId,
                ticket.creatorId,
                ticket.createAt,
                openedAt,
                null,
                ExpiryAt.of(Instant.now().plus(Period.ofDays(3))),
                ticket.content,
                status,
                ticket.actionHistory);
    }

    Ticket(OpenedTicket ticket, OperatorId operatorId, Status status) {
        this(
                ticket.ticketId,
                operatorId,
                ticket.creatorId,
                ticket.createAt,
                ticket.openedAt,
                TerminatedAt.of(Instant.now()),
                ticket.expiryAt,
                ticket.content,
                status,
                ticket.actionHistory);
    }

    Ticket(Ticket ticket, Status status) {
        this(
                ticket.ticketId,
                ticket.operatorId,
                ticket.creatorId,
                ticket.createAt,
                ticket.openedAt,
                TerminatedAt.of(Instant.now()),
                ticket.expiryAt,
                ticket.content,
                status,
                ticket.actionHistory);
    }

    public Ticket(TicketSnapshot ticketSnapshot) {
        this(
                ticketSnapshot.ticketId(),
                ticketSnapshot.operatorId(),
                ticketSnapshot.creatorId(),
                ticketSnapshot.createAt(),
                ticketSnapshot.openedAt(),
                ticketSnapshot.terminatedAt(),
                ticketSnapshot.expiryAt(),
                ticketSnapshot.content(),
                Status.valueOf(ticketSnapshot.status().name()),
                ticketSnapshot.actionHistory());
    }

    public static Ticket create(CreatorId creatorId, Content content) {
        return new NewTicket(creatorId, content);
    }

    public static Ticket from(TicketSnapshot ticketSnapshot) {
        return switch (ticketSnapshot.status()) {
            case NEW -> new NewTicket(ticketSnapshot);
            case OPEN -> new OpenedTicket(ticketSnapshot);
            case CLOSED -> new ClosedTicket(ticketSnapshot);
            case REJECTED -> new RejectedTicket(ticketSnapshot);
            case CANCELED -> new CanceledTicket(ticketSnapshot);
        };
    }

    public Ticket open(OperatorId operatorId) {
        throw new UnsupportedOperationException("Unsupported state of ticket transition");
    }

    public Ticket close(OperatorId operatorId, String desciption) {
        throw new UnsupportedOperationException("Unsupported state of ticket transition");
    }

    public Ticket cancel() {
        throw new UnsupportedOperationException("Unsupported state of ticket transition");
    }

    public TicketSnapshot snapshot() {
        return new TicketSnapshot(
                ticketId,
                creatorId,
                operatorId,
                createAt,
                openedAt,
                terminatedAt,
                expiryAt,
                content,
                TicketSnapshot.Status.valueOf(status.name()),
                actionHistory
        );
    }
}

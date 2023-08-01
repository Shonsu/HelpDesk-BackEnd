package pl.shonsu.userhelpdesk.ticket.domain.model.ticket;

import lombok.Getter;
import pl.shonsu.userhelpdesk.ticket.domain.model.creator.CreatorId;
import pl.shonsu.userhelpdesk.ticket.domain.model.operator.OperatorId;
import pl.shonsu.userhelpdesk.ticket.domain.model.user.UserId;

import java.time.Instant;
import java.time.Period;
import java.util.List;

@Getter
public class Ticket {
    private TicketId ticketId;
    private OperatorId operatorId;
    private CreatorId creatorId;
    private CreatedAt createAt;
    private OpenedAt openedAt;
    private TerminatedAt terminatedAt;
    private ExpiryAt expiryAt;
    private Content content;
    private Status currentStatus;
    private ActionHistory actionHistory;

    private Ticket(TicketId ticketId, OperatorId operatorId,
                   CreatorId creatorId, CreatedAt createAt,
                   OpenedAt openedAt, TerminatedAt terminatedAt,
                   ExpiryAt expiryAt, Content content, Status currentStatus,
                   ActionHistory actionHistory) {
        this.ticketId = ticketId;
        this.operatorId = operatorId;
        this.creatorId = creatorId;
        this.createAt = createAt;
        this.openedAt = openedAt;
        this.terminatedAt = terminatedAt;
        this.expiryAt = expiryAt;
        this.content = content;
        this.currentStatus = currentStatus;
        this.actionHistory = actionHistory;
    }

    public static Ticket create(CreatorId creatorId,
                                Content content) {
        Instant createdAt = Instant.now();
        Action create = new Action(UserId.of(creatorId.id()), Status.NEW, createdAt);
        return new Ticket(
                null,
                null,
                creatorId,
                CreatedAt.of(createdAt),
                null,
                null,
                ExpiryAt.of(createdAt.plus(Period.ofDays(3))),
                content,
                Status.NEW,
                new ActionHistory(List.of(create))
        );
    }

    public void openBy(OperatorId operatorId) {
        if (currentStatus != Status.NEW) {
            throw new IllegalStateException("Cannot open in status: " + currentStatus);
        }
        changeStatus(UserId.of(operatorId.id()), Status.OPEN, Instant.now());
    }

    public void closeBy(OperatorId operatorId) {
        if (currentStatus != Status.NEW && currentStatus != Status.OPEN) {
            throw new IllegalStateException("Cannot close in status: " + currentStatus);
        }
        changeStatus(UserId.of(operatorId.id()), Status.CLOSED, Instant.now());
    }

    public void cancelBy(CreatorId creatorId) {
        if (this.creatorId != creatorId) {
            throw new IllegalArgumentException("Only creator can cancel ticket.");
        }
        this.currentStatus = Status.CANCELED;
        Action cancel = new Action(UserId.of(operatorId.id()), Status.CANCELED, Instant.now());
        actionHistory.addAction(cancel);
    }

    public void rejectBy(OperatorId operatorId) {
        if (currentStatus == Status.CANCELED || currentStatus == Status.CLOSED) {
            throw new IllegalStateException("Cannot reject in status: " + currentStatus);
        }

        this.operatorId = operatorId;
        this.currentStatus = Status.REJECTED;
        Action rejected = new Action(UserId.of(operatorId.id()), Status.REJECTED, Instant.now());
        actionHistory.addAction(rejected);
    }

    public enum Status {
        NEW, OPEN, CLOSED, REJECTED, CANCELED
    }

    private void changeStatus(UserId userId, Status status, Instant timestamp) {
        switch (status) {
            case NEW -> {
                createAt = new CreatedAt(timestamp);
                creatorId = CreatorId.of(userId.id());
            }
            case OPEN -> {
                openedAt = new OpenedAt(timestamp);
                operatorId = OperatorId.of(userId.id());
            }
            case CLOSED, REJECTED, CANCELED -> terminatedAt = new TerminatedAt(timestamp);
            default -> {
                // do nothing
            }
        }
        currentStatus = status;
        Action action = new Action(userId, status, timestamp);
        actionHistory.addAction(action);
    }
    //addAnalysisBy()
    //addQuestionBy()
    //addAnswersBy()
}

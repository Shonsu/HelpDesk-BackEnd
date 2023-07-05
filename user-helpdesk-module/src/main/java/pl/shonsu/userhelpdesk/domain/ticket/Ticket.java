package pl.shonsu.userhelpdesk.domain.ticket;

import pl.shonsu.userhelpdesk.domain.creator.CreatorId;
import pl.shonsu.userhelpdesk.domain.operator.OperatorId;
import pl.shonsu.userhelpdesk.domain.user.UserId;

import java.time.Instant;

public class Ticket {
    private TicketId ticketId;
    private OperatorId operatorId;
    private CreatorId creatorId;
    private CreatedAt createAt;
    private OpenedAt openedAt;
    private ClosedAt closedAt;
    private Content content;
    private Status currentStatus;
    private ActionHistory actionHistory;

    private Ticket(TicketId ticketId, OperatorId operatorId,
                   CreatorId creatorId, CreatedAt createAt,
                   OpenedAt openedAt, ClosedAt closedAt,
                   Content content, Status currentStatus,
                   ActionHistory actionHistory) {
        this.ticketId = ticketId;
        this.operatorId = operatorId;
        this.creatorId = creatorId;
        this.createAt = createAt;
        this.openedAt = openedAt;
        this.closedAt = closedAt;
        this.content = content;
        this.currentStatus = currentStatus;
        this.actionHistory = actionHistory;
    }

    static Ticket create(CreatorId creatorId,
                         Content content,
                         ActionHistory actionHistory) {

        Action create = new Action(UserId.of(creatorId.id()), Status.NEW, Instant.now());
        actionHistory.addAction(create);
        return new Ticket(TicketId.next(), null,
                creatorId, CreatedAt.of(Instant.now()),
                null, null, content, Status.NEW, actionHistory);
    }

    public void openBy(OperatorId operatorId) {
        if (currentStatus != Status.NEW) {
            throw new IllegalStateException("Cannot open in status: " + currentStatus);
        }
        this.operatorId = operatorId;
        this.openedAt = new OpenedAt(Instant.now());
        this.currentStatus = Status.OPEN;
        Action open = new Action(UserId.of(operatorId.id()), Status.OPEN, this.openedAt.time());
        actionHistory.addAction(open);
    }

    public void closeBy(OperatorId operatorId) {
        if (currentStatus != Status.NEW && currentStatus != Status.OPEN) {
            throw new IllegalStateException("Cannot close in status: " + currentStatus);
        }
        this.operatorId = operatorId;
        this.closedAt = new ClosedAt(Instant.now());
        this.currentStatus = Status.CLOSED;
        Action close = new Action(UserId.of(operatorId.id()), Status.CLOSED, this.closedAt.time());
        actionHistory.addAction(close);

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

    enum Status {
        NEW, OPEN, CLOSED, REJECTED, CANCELED, QUESTION, ANSWER, ANALYSIS
    }

    //addAnalysisBy()
    //addQuestionBy()
    //addAnswersBy()
}

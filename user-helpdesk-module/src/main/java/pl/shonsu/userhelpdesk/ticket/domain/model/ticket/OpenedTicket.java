package pl.shonsu.userhelpdesk.ticket.domain.model.ticket;

import pl.shonsu.userhelpdesk.ticket.domain.model.operator.OperatorId;

public final class OpenedTicket extends TicketV2 {
    public OpenedTicket(NewTicket ticket, OperatorId operatorId, Status open) {
        super(ticket, operatorId, open);
    }

    public OpenedTicket(TicketSnapshot ticketSnapshot) {
        super(ticketSnapshot);
    }

    public ClosedTicket close(OperatorId operatorId) {
        return new ClosedTicket(this, operatorId, Status.CLOSED);
    }

    public CanceledTicket cancel() {
        return new CanceledTicket(this, Status.CANCELED);
    }

    public RejectedTicket reject(OperatorId operatorId) {
        return new RejectedTicket(this, operatorId, Status.REJECTED);
    }
}

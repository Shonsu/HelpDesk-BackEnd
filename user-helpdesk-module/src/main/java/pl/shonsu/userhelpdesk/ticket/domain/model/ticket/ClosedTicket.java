package pl.shonsu.userhelpdesk.ticket.domain.model.ticket;

import pl.shonsu.userhelpdesk.ticket.domain.model.operator.OperatorId;

public final class ClosedTicket extends Ticket {
    public ClosedTicket(OpenedTicket ticket, OperatorId operatorId, Status status) {
        super(ticket, operatorId, status);
    }

    public ClosedTicket(TicketSnapshot ticketSnapshot) {
        super(ticketSnapshot);
    }
}

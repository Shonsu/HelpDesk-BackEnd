package pl.shonsu.userhelpdesk.ticket.domain.model.ticket;

import pl.shonsu.userhelpdesk.ticket.domain.model.operator.OperatorId;

public final class RejectedTicket extends TicketV2 {

    public RejectedTicket(OpenedTicket ticket, OperatorId operatorId, Status rejected) {
        super(ticket, operatorId, rejected);
    }

    public RejectedTicket(TicketSnapshot ticketSnapshot) {
        super(ticketSnapshot);
    }
}

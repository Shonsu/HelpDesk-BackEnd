package pl.shonsu.userhelpdesk.ticket.domain.model.ticket;

import pl.shonsu.userhelpdesk.ticket.domain.model.creator.CreatorId;
import pl.shonsu.userhelpdesk.ticket.domain.model.operator.OperatorId;

public final class NewTicket extends TicketV2 {
    NewTicket(CreatorId creatorId, Content content) {
        super(creatorId, content, Status.NEW);
    }

    public NewTicket(TicketSnapshot ticketSnapshot) {
        super(ticketSnapshot);
    }

    TicketV2 open(OperatorId operatorId) {
        return new OpenedTicket(this, operatorId, Status.OPEN);
    }

}

package pl.shonsu.userhelpdesk.ticket.domain.model.ticket;

public final class CanceledTicket extends Ticket {
    CanceledTicket(OpenedTicket ticket, Status canceled) {
        super(ticket, canceled);
    }

    public CanceledTicket(TicketSnapshot ticketSnapshot) {
        super(ticketSnapshot);
    }
}

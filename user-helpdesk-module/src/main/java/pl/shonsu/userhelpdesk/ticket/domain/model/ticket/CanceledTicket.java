package pl.shonsu.userhelpdesk.ticket.domain.model.ticket;

public final class CanceledTicket extends Ticket {
    CanceledTicket(Ticket ticket, Status canceled) {
        super(ticket, canceled);
    }

    public CanceledTicket(TicketSnapshot ticketSnapshot) {
        super(ticketSnapshot);
    }
}

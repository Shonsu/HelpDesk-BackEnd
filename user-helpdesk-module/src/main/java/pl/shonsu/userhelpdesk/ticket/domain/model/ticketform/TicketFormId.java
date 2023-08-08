package pl.shonsu.userhelpdesk.ticket.domain.model.ticketform;

public record TicketFormId(Long id) {
    public static TicketFormId of(Long id) {
        return new TicketFormId(id);
    }
}

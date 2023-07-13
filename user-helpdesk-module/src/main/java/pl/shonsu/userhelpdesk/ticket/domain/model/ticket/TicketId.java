package pl.shonsu.userhelpdesk.ticket.domain.model.ticket;

public record TicketId(Long id) {
//    public static TicketId next(){
//        return new TicketId(UUID.randomUUID().toString());
//    }
    public static TicketId of(Long id){
        return new TicketId(id);
    }
}

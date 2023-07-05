package pl.shonsu.userhelpdesk.domain.ticket;

import java.util.UUID;

record TicketId(String id) {
    public static TicketId next(){
        return new TicketId(UUID.randomUUID().toString());
    }
    public static TicketId of(String id){
        return new TicketId(id);
    }
}

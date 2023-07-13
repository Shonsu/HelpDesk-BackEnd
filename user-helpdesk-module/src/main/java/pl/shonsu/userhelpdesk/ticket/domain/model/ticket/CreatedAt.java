package pl.shonsu.userhelpdesk.ticket.domain.model.ticket;

import java.time.Instant;

public record CreatedAt(Instant time) {
    public static CreatedAt of(Instant time){
        return new CreatedAt(time);
    }
}

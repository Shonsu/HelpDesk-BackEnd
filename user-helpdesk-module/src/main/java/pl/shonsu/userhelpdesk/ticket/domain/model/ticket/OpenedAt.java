package pl.shonsu.userhelpdesk.ticket.domain.model.ticket;

import java.time.Instant;

record OpenedAt(Instant time) {
    public static OpenedAt of(Instant time){
        return new OpenedAt(time);
    }
}

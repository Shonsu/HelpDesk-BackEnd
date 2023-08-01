package pl.shonsu.userhelpdesk.ticket.domain.model.ticket;

import java.time.Instant;

record TerminatedAt(Instant time) {
    public static TerminatedAt of(Instant time){
        return new TerminatedAt(time);
    }
}

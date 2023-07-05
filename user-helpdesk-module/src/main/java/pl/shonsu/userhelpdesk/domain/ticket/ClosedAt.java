package pl.shonsu.userhelpdesk.domain.ticket;

import java.time.Instant;

record ClosedAt(Instant time) {
    public static ClosedAt of(Instant time){
        return new ClosedAt(time);
    }
}

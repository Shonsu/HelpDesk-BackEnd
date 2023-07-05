package pl.shonsu.userhelpdesk.domain.ticket;

import java.time.Instant;

record CreatedAt(Instant time) {
    public static CreatedAt of(Instant time){
        return new CreatedAt(time);
    }
}

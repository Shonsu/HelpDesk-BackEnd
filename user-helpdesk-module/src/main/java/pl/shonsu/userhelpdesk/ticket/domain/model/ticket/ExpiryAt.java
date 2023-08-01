package pl.shonsu.userhelpdesk.ticket.domain.model.ticket;

import java.time.Instant;

public record ExpiryAt(Instant time) {
    public static ExpiryAt of(Instant time) {
        return new ExpiryAt(time);
    }
}

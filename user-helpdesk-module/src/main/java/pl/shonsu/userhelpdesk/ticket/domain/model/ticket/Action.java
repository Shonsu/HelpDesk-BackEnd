package pl.shonsu.userhelpdesk.ticket.domain.model.ticket;

import pl.shonsu.userhelpdesk.ticket.domain.model.user.UserId;

import java.time.Instant;

public record Action(ActionId actionId, UserId who, Ticket.Status what, String description, Instant timestamp) {

    public Action(UserId who, Ticket.Status what, String description, Instant timestamp) {
        this(null, who, what, description, timestamp);
    }

    public Action(UserId who, Ticket.Status what, Instant timestamp) {
        this(null, who, what, null, timestamp);
    }

    public record ActionId(Long id) {
        public static ActionId of(Long id) {
            return new ActionId(id);
        }
    }
}
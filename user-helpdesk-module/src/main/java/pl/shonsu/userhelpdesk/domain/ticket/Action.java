package pl.shonsu.userhelpdesk.domain.ticket;

import pl.shonsu.userhelpdesk.domain.user.UserId;

import java.time.Instant;

record Action(ActionId actionId, UserId who, Ticket.Status what, String description, Instant timestamp) {

    public Action(UserId who, Ticket.Status what, String description, Instant timestamp) {
        this(null, who, what, description, timestamp);
    }

    public Action(UserId who, Ticket.Status what, Instant timestamp) {
        this(null, who, what, null, timestamp);
    }

    private record ActionId(Long id) {
        public static ActionId of(Long id) {
            return new ActionId(id);
        }
    }
}
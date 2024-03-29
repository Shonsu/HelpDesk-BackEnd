package pl.shonsu.userhelpdesk.ticket.domain.model.ticket;

import pl.shonsu.userhelpdesk.ticket.domain.model.user.UserId;

import java.time.Instant;

public record Action(ActionId actionId, UserId who, Status what, String description, Instant timestamp, TicketId ticketId) {

    public Action(UserId who, Status what, Instant timestamp, String description) {
        this(null, who, what, description, timestamp,null);
    }

    public Action(UserId who, Status what, Instant timestamp) {
        this(null, who, what, null, timestamp, null);
    }

    public record ActionId(Long id) {
        public static ActionId of(Long id) {
            return new ActionId(id);
        }
    }
}
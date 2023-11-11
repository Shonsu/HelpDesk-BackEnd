package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.repository;

import org.hibernate.query.TupleTransformer;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.TicketViewResponse;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.entity.Status;

import java.time.Instant;

public class TicketViewResponseTransformer implements TupleTransformer<TicketViewResponse> {
    @Override
    public TicketViewResponse transformTuple(Object[] tuple, String[] aliases) {
        return new TicketViewResponse(
                ((Integer) tuple[0]).longValue(),
                (String) tuple[1],
                (Instant) tuple[2],
                Status.valueOf((String) tuple[3]));
    }
}

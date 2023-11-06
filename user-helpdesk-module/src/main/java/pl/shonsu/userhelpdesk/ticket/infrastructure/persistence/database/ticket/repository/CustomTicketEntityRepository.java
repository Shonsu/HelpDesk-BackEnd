package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.repository;

import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.repository.dto.TicketEntityShortInfo;

import java.util.List;
import java.util.Optional;

public interface CustomTicketEntityRepository {
    Optional<TicketEntityShortInfo> getTicketShortInfoById(Long id);

    Optional<TicketEntityShortInfo> getTicketShortInfoById2(Long id);

    List<TicketEntityShortInfo> getAllUserTicketsShortInfo(Long userId);
}

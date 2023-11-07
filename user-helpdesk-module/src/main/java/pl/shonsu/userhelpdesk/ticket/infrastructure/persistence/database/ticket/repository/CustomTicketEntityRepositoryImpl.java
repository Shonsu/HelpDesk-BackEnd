package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.hibernate.jpa.AvailableHints;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.entity.Status;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.repository.dto.TicketEntityShortInfo;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public class CustomTicketEntityRepositoryImpl implements CustomTicketEntityRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<TicketEntityShortInfo> getTicketShortInfoById(Long id) {
        Query q = em.createNativeQuery(
                        "select CAST(id as bigint), " +
                                "CAST(content ->> 'ticketFormId' as bigint) as ticketFormId, " +
                                "create_date, " +
                                "status " +
                                "from ticket where id = :id"
                )
                .setHint(AvailableHints.HINT_READ_ONLY, true)
                .setParameter("id", id);
        try {
            Object[] obj = (Object[]) q.getSingleResult();
            return Optional.of(new TicketEntityShortInfo((Long) obj[0], (Long) obj[1], (Instant) obj[2], Status.valueOf((String) obj[3])));
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<TicketEntityShortInfo> getTicketShortInfoById2(Long id) {

        Query query = em.createNativeQuery(
                        "select CAST(id as bigint), " +
                                "CAST(content ->> 'ticketFormId' as bigint) as ticketFormId, " +
                                "create_date as createdAt, " +
                                "status " +
                                "from ticket where id = :id",
                        "TicketEntityShortInfo"
                )
                .setHint(AvailableHints.HINT_READ_ONLY, true)
                .setParameter("id", id);
        try {
            return Optional.of((TicketEntityShortInfo) query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<TicketEntityShortInfo> getAllUserTicketsShortInfo(Long userId) {

        @SuppressWarnings("unchecked")
        List<TicketEntityShortInfo> resultList = (List<TicketEntityShortInfo>) em.createNativeQuery(
                        "select CAST(id as bigint), " +
                                "CAST(content ->> 'ticketFormId' as bigint) as ticketFormId, " +
                                "create_date as createdAt, " +
                                "status " +
                                "from ticket where creator_id = :id",
                        "TicketEntityShortInfo"
                )
                .setHint(AvailableHints.HINT_READ_ONLY, true)
                .setParameter("id", userId)
                .getResultList();

        return resultList;
    }

}

package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticketsubcategory;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticketsubcategory.entity.TicketSubCategoryEntity;

import java.util.Collection;
import java.util.List;

public interface TicketSubCategoryEntityRepository extends JpaRepository<TicketSubCategoryEntity, Long> {
    List<TicketSubCategoryEntity> findByIdIn(Collection<Long> subCategoryIds);
}

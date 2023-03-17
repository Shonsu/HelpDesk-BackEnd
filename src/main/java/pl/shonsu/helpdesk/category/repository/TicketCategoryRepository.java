package pl.shonsu.helpdesk.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shonsu.helpdesk.category.controller.dto.TicketCategoryView;
import pl.shonsu.helpdesk.category.model.TicketCategory;

import java.util.List;

public interface TicketCategoryRepository extends JpaRepository<TicketCategory, Long> {
    List<TicketCategoryView> findAllBy();
}

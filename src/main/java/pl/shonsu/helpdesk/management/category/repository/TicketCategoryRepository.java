package pl.shonsu.helpdesk.management.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shonsu.helpdesk.management.category.controller.dto.TicketCategoryView;
import pl.shonsu.helpdesk.management.category.model.TicketCategory;

import java.util.List;

public interface TicketCategoryRepository extends JpaRepository<TicketCategory, Long> {
    List<TicketCategoryView> findAllBy();

    List<TicketCategoryView> findByLabelContainingIgnoreCase(String searchText);
}

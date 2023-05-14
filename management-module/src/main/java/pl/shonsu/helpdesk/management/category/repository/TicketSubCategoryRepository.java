package pl.shonsu.helpdesk.management.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shonsu.helpdesk.management.category.controller.dto.TicketSubCategoryView;
import pl.shonsu.helpdesk.management.category.model.TicketSubCategory;

import java.util.List;

public interface TicketSubCategoryRepository extends JpaRepository<TicketSubCategory, Long> {
    List<TicketSubCategoryView> findAllByLabelContainingIgnoreCase(String text);

    List<TicketSubCategoryView> findAllBy();
}
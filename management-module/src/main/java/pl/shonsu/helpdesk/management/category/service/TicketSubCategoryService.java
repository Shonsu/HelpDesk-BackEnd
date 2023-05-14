package pl.shonsu.helpdesk.management.category.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.shonsu.helpdesk.management.category.controller.dto.TicketSubCategoryView;
import pl.shonsu.helpdesk.management.category.model.TicketSubCategory;
import pl.shonsu.helpdesk.management.category.repository.TicketSubCategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketSubCategoryService {

    private final TicketSubCategoryRepository subCategoryRepository;
    public TicketSubCategory createTicketSubCategory(TicketSubCategory ticketSubCategory) {
        return subCategoryRepository.save(ticketSubCategory);
    }

    public List<TicketSubCategoryView> getTicketSubCategories() {
        return subCategoryRepository.findAllBy();
    }

    public TicketSubCategory getTicketSubCategory(Long id) {
        return subCategoryRepository.findById(id).orElseThrow();
    }

    public TicketSubCategory updateTicketSubCategory(TicketSubCategory ticketSubCategory) {
        return subCategoryRepository.save(ticketSubCategory);
    }

    public void deleteTicketSubCategory(Long id) {
        subCategoryRepository.deleteById(id);
    }

    public List<TicketSubCategoryView> searchTicketSubCategories(String text) {
        return subCategoryRepository.findAllByLabelContainingIgnoreCase(text);
    }
}

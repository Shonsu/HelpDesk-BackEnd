package pl.shonsu.helpdesk.management.category.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.shonsu.helpdesk.management.category.controller.dto.TicketCategoryView;
import pl.shonsu.helpdesk.management.category.model.TicketCategory;
import pl.shonsu.helpdesk.management.category.repository.TicketCategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public
class TicketCategoryService {
    private final TicketCategoryRepository ticketCategoryRepository;

    public TicketCategory createTicketCategory(TicketCategory ticketCategory) {
        return ticketCategoryRepository.save(ticketCategory);
    }

    public TicketCategory getTicketCategory(Long id) {
        return ticketCategoryRepository.findById(id).orElseThrow();
    }

    public List<TicketCategoryView> getTicketCategories() {
        return ticketCategoryRepository.findAllBy();
    }

    public TicketCategory updateCategory(TicketCategory ticketCategory) {
        return ticketCategoryRepository.save(ticketCategory);
    }

    public void deleteTicketCategory(Long id) {
        //TODO check if subdirectiories exists
        ticketCategoryRepository.deleteById(id);
    }

    public List<TicketCategoryView> searchTicketCategories(String searchText) {
        return ticketCategoryRepository.findByLabelContainingIgnoreCase(searchText);
    }
}

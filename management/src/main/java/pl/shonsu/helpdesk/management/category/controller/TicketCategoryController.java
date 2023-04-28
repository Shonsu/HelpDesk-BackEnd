package pl.shonsu.helpdesk.management.category.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.shonsu.helpdesk.management.category.controller.dto.TicketCategoryDto;
import pl.shonsu.helpdesk.management.category.controller.dto.TicketCategoryView;
import pl.shonsu.helpdesk.management.category.model.TicketCategory;
import pl.shonsu.helpdesk.management.category.service.TicketCategoryService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin/categories")
@RequiredArgsConstructor
class TicketCategoryController {

    public static final Long EMPTY_ID = null;
    private final TicketCategoryService ticketCategoryService;

    @PostMapping
    TicketCategory createTicketCategory(@RequestBody @Valid TicketCategoryDto ticketCategoryDto) {
        return ticketCategoryService.createTicketCategory(mapToTicketCategory(ticketCategoryDto, EMPTY_ID));
    }
    @GetMapping
    List<TicketCategoryView> getTicketCategories() {
        return ticketCategoryService.getTicketCategories();
    }
    @GetMapping("/{id}")
    TicketCategory getTicketCategory(@PathVariable Long id){
        return ticketCategoryService.getTicketCategory(id);
    }

    @PutMapping("/{id}")
    TicketCategory updateCategory(@PathVariable Long id, @RequestBody @Valid TicketCategoryDto ticketCategoryDto){
        return ticketCategoryService.updateCategory(mapToTicketCategory(ticketCategoryDto, id));
    }

    @DeleteMapping("/{id}")
    public void deleteTicketCategory(@PathVariable Long id){
        ticketCategoryService.deleteTicketCategory(id);
    }

    @GetMapping("/search")
    List<TicketCategoryView> searchTicketCategories(@RequestParam(name = "text") String text){
        return ticketCategoryService.searchTicketCategories(text);
    }

    private TicketCategory mapToTicketCategory(TicketCategoryDto ticketCategoryDto, Long id) {
        return TicketCategory.builder()
                .id(id)
                .label(ticketCategoryDto.getLabel())
                .description(ticketCategoryDto.getDescription())
                .build();
    }
}

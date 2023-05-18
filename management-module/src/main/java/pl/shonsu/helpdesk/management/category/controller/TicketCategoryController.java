package pl.shonsu.helpdesk.management.category.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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

    private static final Long EMPTY_ID = null;
    private final TicketCategoryService ticketCategoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    TicketCategory createTicketCategory(@RequestBody @Valid TicketCategoryDto ticketCategoryDto) {
        return ticketCategoryService.createTicketCategory(mapToTicketCategory(ticketCategoryDto, EMPTY_ID));
    }
    @GetMapping
    List<TicketCategoryView> getTicketCategories() {
        return ticketCategoryService.getTicketCategories();
    }
    @GetMapping("/{categoryId}")
    TicketCategory getTicketCategory(@PathVariable Long categoryId){
        return ticketCategoryService.getTicketCategory(categoryId);
    }

    @PutMapping("/{categoryId}")
    TicketCategory updateCategory(@PathVariable Long categoryId, @RequestBody @Valid TicketCategoryDto ticketCategoryDto){
        return ticketCategoryService.updateCategory(mapToTicketCategory(ticketCategoryDto, categoryId));
    }

    @DeleteMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTicketCategory(@PathVariable Long categoryId){
        ticketCategoryService.deleteTicketCategory(categoryId);
    }

    @GetMapping("/search")
    List<TicketCategoryView> searchTicketCategories(@RequestParam(name = "text") String text){
        return ticketCategoryService.searchTicketCategories(text);
    }

    private TicketCategory mapToTicketCategory(TicketCategoryDto ticketCategoryDto, Long categoryId) {
        return TicketCategory.builder()
                .id(categoryId)
                .label(ticketCategoryDto.getLabel())
                .description(ticketCategoryDto.getDescription())
                .build();
    }
}

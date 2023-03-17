package pl.shonsu.helpdesk.category.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.shonsu.helpdesk.category.controller.dto.TicketCategoryDto;
import pl.shonsu.helpdesk.category.controller.dto.TicketCategoryView;
import pl.shonsu.helpdesk.category.model.TicketCategory;
import pl.shonsu.helpdesk.category.service.TicketCategoryService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin/categories")
@RequiredArgsConstructor
class CategoryController {

    public static final Long EMPTY_ID = null;
    private final TicketCategoryService ticketCategoryService;

    @PostMapping
    TicketCategory createTicketCategory(@RequestBody TicketCategoryDto ticketCategoryDto) {
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
    TicketCategory updateCategory(@PathVariable Long id, @RequestBody TicketCategoryDto ticketCategoryDto){
        return ticketCategoryService.updateCategory(mapToTicketCategory(ticketCategoryDto, id));
    }

    private TicketCategory mapToTicketCategory(TicketCategoryDto ticketCategoryDto, Long id) {
        return TicketCategory.builder()
                .id(id)
                .label(ticketCategoryDto.getLabel())
                .description(ticketCategoryDto.getDescription())
                .build();
    }
}

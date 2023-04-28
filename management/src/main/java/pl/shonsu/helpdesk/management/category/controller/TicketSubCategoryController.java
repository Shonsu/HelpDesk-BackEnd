package pl.shonsu.helpdesk.management.category.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.shonsu.helpdesk.management.category.controller.dto.TicketSubCategoryDto;
import pl.shonsu.helpdesk.management.category.controller.dto.TicketSubCategoryView;
import pl.shonsu.helpdesk.management.category.model.TicketSubCategory;
import pl.shonsu.helpdesk.management.category.service.TicketSubCategoryService;

import java.util.List;

@RestController
@RequestMapping("/admin/subcategories")
@RequiredArgsConstructor
class TicketSubCategoryController {

    public static final Long EMPTY_ID = null;
    private final TicketSubCategoryService subCategoryService;

    @PostMapping
    TicketSubCategory createTicketSubCategory(@RequestBody @Valid TicketSubCategoryDto ticketSubCategoryDto) {
        return subCategoryService.createTicketSubCategory(mapToTicketSubCategory(ticketSubCategoryDto, EMPTY_ID));
    }

    @GetMapping
    List<TicketSubCategoryView> getTicketSubCategories() {
        return subCategoryService.getTicketSubCategories();
    }

    @GetMapping("/{id}")
    TicketSubCategory getTicketSubCategory(@PathVariable Long id) {
        return subCategoryService.getTicketSubCategory(id);
    }

    @PutMapping("/{id}")
    TicketSubCategory updateTicketSubCategory(@PathVariable Long id, @RequestBody @Valid TicketSubCategoryDto ticketSubCategoryDto) {
        return subCategoryService.updateTicketSubCategory(mapToTicketSubCategory(ticketSubCategoryDto, id));
    }

    @DeleteMapping("/{id}")
    public void deleteTicketSubCategory(@PathVariable Long id) {
        subCategoryService.deleteTicketSubCategory(id);
    }

    @GetMapping("/search")
    public List<TicketSubCategoryView> searchTicketSubCategories(@RequestParam(name = "text") String text) {
        return subCategoryService.searchTicketSubCategories(text);
    }

    private TicketSubCategory mapToTicketSubCategory(TicketSubCategoryDto ticketSubCategoryDto, Long id) {
        return TicketSubCategory.builder()
                .id(id)
                .label(ticketSubCategoryDto.getLabel())
                .description(ticketSubCategoryDto.getDescription())
                .ticketCategoryId(ticketSubCategoryDto.getTicketCategoryId())
                .build();
    }
}

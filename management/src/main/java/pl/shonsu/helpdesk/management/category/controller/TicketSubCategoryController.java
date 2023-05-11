package pl.shonsu.helpdesk.management.category.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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
    @ResponseStatus(HttpStatus.CREATED)
    TicketSubCategory createTicketSubCategory(@RequestBody @Valid TicketSubCategoryDto ticketSubCategoryDto) {
        return subCategoryService.createTicketSubCategory(mapToTicketSubCategory(ticketSubCategoryDto, EMPTY_ID));
    }

    @GetMapping
    List<TicketSubCategoryView> getTicketSubCategories() {
        return subCategoryService.getTicketSubCategories();
    }

    @GetMapping("/{subCategoryId}")
    TicketSubCategory getTicketSubCategory(@PathVariable Long subCategoryId) {
        return subCategoryService.getTicketSubCategory(subCategoryId);
    }

    @PutMapping("/{subCategoryId}")
    TicketSubCategory updateTicketSubCategory(@PathVariable Long subCategoryId, @RequestBody @Valid TicketSubCategoryDto ticketSubCategoryDto) {
        return subCategoryService.updateTicketSubCategory(mapToTicketSubCategory(ticketSubCategoryDto, subCategoryId));
    }

    @DeleteMapping("/{subCategoryId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTicketSubCategory(@PathVariable Long subCategoryId) {
        subCategoryService.deleteTicketSubCategory(subCategoryId);
    }

    @GetMapping("/search")
    public List<TicketSubCategoryView> searchTicketSubCategories(@RequestParam(name = "text") String text) {
        return subCategoryService.searchTicketSubCategories(text);
    }

    private TicketSubCategory mapToTicketSubCategory(TicketSubCategoryDto ticketSubCategoryDto, Long subCategoryId) {
        return TicketSubCategory.builder()
                .id(subCategoryId)
                .label(ticketSubCategoryDto.getLabel())
                .description(ticketSubCategoryDto.getDescription())
                .ticketCategoryId(ticketSubCategoryDto.getTicketCategoryId())
                .build();
    }
}

package pl.shonsu.helpdesk.management.category.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
public class TicketCategoryDto {
    @NotBlank
    @Length(min = 4)
    private String label;
    private String description;
}

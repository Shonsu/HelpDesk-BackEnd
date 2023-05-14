package pl.shonsu.helpdesk.management.category.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
public class TicketSubCategoryDto {
    @NotBlank
    @Length(min = 4)
    private String label;
    private String description;
    @NotNull
    private Long ticketCategoryId;
}

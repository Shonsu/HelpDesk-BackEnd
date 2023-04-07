package pl.shonsu.helpdesk.management.ticket.controller.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class TicketFormDto {
    private String label;
    private Long subCategoryId;
    List<TicketFormFieldDto> ticketFormFields;
}

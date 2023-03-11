package pl.shonsu.helpdesk.ticket.controller.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class TicketFormDto {
    private Long categoryId;
    private Long subCategoryId;
    List<TicketFormFieldDto> ticketFormFieldDtos;
}

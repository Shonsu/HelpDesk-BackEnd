package pl.shonsu.helpdesk.management.ticketform.controller.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TicketFormFieldOptionDto {
    private Long id;
    private String key;
    private String value;
}

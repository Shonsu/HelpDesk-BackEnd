package pl.shonsu.helpdesk.management.ticket.controller.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class TicketFormFieldDto {
    private Long id;
    private String key;
    private String label;
    private boolean required;
    private int order;
    private String controlType;
    private List<TicketFormFieldOptionDto> options;
    private String type;
}

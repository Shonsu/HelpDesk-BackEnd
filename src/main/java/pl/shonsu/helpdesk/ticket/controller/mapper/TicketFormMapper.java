package pl.shonsu.helpdesk.ticket.controller.mapper;

import pl.shonsu.helpdesk.ticket.controller.dto.TicketFormDto;
import pl.shonsu.helpdesk.ticket.controller.dto.TicketFormFieldDto;
import pl.shonsu.helpdesk.ticket.model.TicketForm;
import pl.shonsu.helpdesk.ticket.model.TicketFormField;
import pl.shonsu.helpdesk.ticket.model.TicketFormFieldOption;

import java.util.List;

public class TicketFormMapper {

    public static TicketForm mapToTicketForm(TicketFormDto ticketFormDto) {
        return TicketForm.builder()
                .subCategoryId(ticketFormDto.getSubCategoryId())
                .ticketFormFieldList(mapToFieldList(ticketFormDto))
                .build();
    }

    private static List<TicketFormField> mapToFieldList(TicketFormDto ticketFormDto) {
        return ticketFormDto.getTicketFormFieldDtos().stream()
                .map(TicketFormMapper::mapToField).toList();
    }

    private static TicketFormField mapToField(TicketFormFieldDto ticketFormFieldDto) {
        return TicketFormField.builder()
                .key(ticketFormFieldDto.getKey())
                .label(ticketFormFieldDto.getLabel())
                .required(ticketFormFieldDto.isRequired())
                .order(ticketFormFieldDto.getOrder())
                .controlType(ticketFormFieldDto.getControlType())
                .options(mapToFieldOptions(ticketFormFieldDto))
                .build();
    }

    private static List<TicketFormFieldOption> mapToFieldOptions(TicketFormFieldDto ticketFormFieldDto) {
        return ticketFormFieldDto.getOptions().stream()
                .map(ticketFormFieldOptionDto -> TicketFormFieldOption.builder()
                        .key(ticketFormFieldOptionDto.getKey())
                        .value(ticketFormFieldOptionDto.getValue())
                        .build())
                .toList();
    }

}

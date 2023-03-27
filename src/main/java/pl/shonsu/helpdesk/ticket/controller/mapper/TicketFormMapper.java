package pl.shonsu.helpdesk.ticket.controller.mapper;

import pl.shonsu.helpdesk.ticket.controller.dto.TicketFormDto;
import pl.shonsu.helpdesk.ticket.controller.dto.TicketFormFieldDto;
import pl.shonsu.helpdesk.ticket.model.ControlType;
import pl.shonsu.helpdesk.ticket.model.TicketForm;
import pl.shonsu.helpdesk.ticket.model.TicketFormField;
import pl.shonsu.helpdesk.ticket.model.TicketFormFieldOption;

import java.util.List;

public class TicketFormMapper {

    public static TicketForm mapToTicketForm(TicketFormDto ticketFormDto, Long id) {
        return TicketForm.builder()
                .id(id)
                .label(ticketFormDto.getLabel())
                .subCategoryId(ticketFormDto.getSubCategoryId())
                .ticketFormFields(mapToFieldList(ticketFormDto))
                .build();
    }

    private static List<TicketFormField> mapToFieldList(TicketFormDto ticketFormDto) {
        return ticketFormDto.getTicketFormFields().stream()
                .map(TicketFormMapper::mapToField).toList();
    }

    private static TicketFormField mapToField(TicketFormFieldDto ticketFormFieldDto) {
        return TicketFormField.builder()
                .id((ticketFormFieldDto.getId() != null ? ticketFormFieldDto.getId() : null))
                .key(ticketFormFieldDto.getKey())
                .label(ticketFormFieldDto.getLabel())
                .required(ticketFormFieldDto.isRequired())
                .order(ticketFormFieldDto.getOrder())
                .controlType(ControlType.valueOf(ticketFormFieldDto.getControlType()))
                .options(mapToFieldOptions(ticketFormFieldDto))
                .type(ticketFormFieldDto.getType())
                .build();
    }

    private static List<TicketFormFieldOption> mapToFieldOptions(TicketFormFieldDto ticketFormFieldDto) {
        return ticketFormFieldDto.getOptions().stream()
                .map(ticketFormFieldOptionDto -> TicketFormFieldOption.builder()
                        .id(ticketFormFieldDto.getId() != null ? ticketFormFieldDto.getId() : null)
                        .key(ticketFormFieldOptionDto.getKey())
                        .value(ticketFormFieldOptionDto.getValue())
                        .build())
                .toList();
    }

}

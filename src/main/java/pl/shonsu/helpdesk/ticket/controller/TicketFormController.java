package pl.shonsu.helpdesk.ticket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.shonsu.helpdesk.ticket.controller.dto.TicketFormDto;
import pl.shonsu.helpdesk.ticket.model.TicketForm;
import pl.shonsu.helpdesk.ticket.model.TicketFormField;
import pl.shonsu.helpdesk.ticket.model.TicketFormFieldOption;
import pl.shonsu.helpdesk.ticket.service.TicketFormService;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/ticketforms")
@RequiredArgsConstructor
class TicketFormController {
    private final TicketFormService ticketFormService;

    @PostMapping
    TicketForm createTicketForm(@RequestBody TicketFormDto ticketFormDto) {
        System.out.println(ticketFormDto);
        return ticketFormService.createTicketForm(mapToTicketForm(ticketFormDto));
    }

    private TicketForm mapToTicketForm(TicketFormDto ticketFormDto) {
        return TicketForm.builder()
                .categoryId(ticketFormDto.getCategoryId())
                .subCategoryId(ticketFormDto.getSubCategoryId())
                .ticketFormFieldList(ticketFormDto.getTicketFormFieldDtos().stream()
                        .map(ticketFormFieldDto -> TicketFormField.builder()
                                .key(ticketFormFieldDto.getKey())
                                .label(ticketFormFieldDto.getLabel())
                                .required(ticketFormFieldDto.isRequired())
                                .order(ticketFormFieldDto.getOrder())
                                .controlType(ticketFormFieldDto.getControlType())
                                .options(ticketFormFieldDto.getOptions().stream()
                                        .map(ticketFormFieldOptionDto -> TicketFormFieldOption.builder()
                                                .key(ticketFormFieldOptionDto.getKey())
                                                .value(ticketFormFieldOptionDto.getValue())
                                                .build())
                                        .toList())
                                .build()).toList())
                .build();
    }
}

package pl.shonsu.helpdesk.management.ticket.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.shonsu.helpdesk.management.ticket.controller.dto.TicketFormDto;
import pl.shonsu.helpdesk.management.ticket.controller.mapper.TicketFormMapper;
import pl.shonsu.helpdesk.management.ticket.controller.dto.TicketFormNameDto;
import pl.shonsu.helpdesk.management.ticket.model.TicketForm;
import pl.shonsu.helpdesk.management.ticket.service.TicketFormService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin/ticketforms")
@RequiredArgsConstructor
class TicketFormController {
    public static final Long EMPTY_ID = null;
    private final TicketFormService ticketFormService;

    @PostMapping
    TicketForm createTicketForm(@RequestBody TicketFormDto ticketFormDto) {
        log.info(String.valueOf(ticketFormDto));
        return ticketFormService.createTicketForm(TicketFormMapper.mapToTicketForm(ticketFormDto, EMPTY_ID));
    }

    @GetMapping("/{id}")
    TicketForm getTicketForm(@PathVariable Long id) {
        return ticketFormService.getTicketForm(id);
    }

    @GetMapping
    List<TicketFormNameDto> getTicketForms() {
        return ticketFormService.getTicketFormsView();
    }

    @PutMapping("/{id}")
    TicketForm updateTicketForm(@PathVariable Long id, @RequestBody TicketFormDto ticketFormDto){
        return ticketFormService.updateTicketForm(TicketFormMapper.mapToTicketForm(ticketFormDto, id));
    }

    @DeleteMapping("/{id}")
    void deleteTicketForm(@PathVariable Long id){
        ticketFormService.deleteTicketForm(id);
    }
}

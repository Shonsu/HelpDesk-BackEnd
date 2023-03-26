package pl.shonsu.helpdesk.ticket.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.shonsu.helpdesk.ticket.controller.dto.TicketFormDto;
import pl.shonsu.helpdesk.ticket.controller.dto.TicketFormNameDto;
import pl.shonsu.helpdesk.ticket.model.TicketForm;
import pl.shonsu.helpdesk.ticket.service.TicketFormService;

import java.util.List;

import static pl.shonsu.helpdesk.ticket.controller.mapper.TicketFormMapper.mapToTicketForm;

@Slf4j
@RestController
@RequestMapping("/admin/ticketforms")
@RequiredArgsConstructor
class TicketFormController {
    private final TicketFormService ticketFormService;

    @PostMapping
    TicketForm createTicketForm(@RequestBody TicketFormDto ticketFormDto) {
        log.info(String.valueOf(ticketFormDto));
        return ticketFormService.createTicketForm(mapToTicketForm(ticketFormDto));
    }

    @GetMapping("/{id}")
    TicketForm getTicketForm(@PathVariable Long id) {
        return ticketFormService.getTicketForm(id);
    }

    @GetMapping
    List<TicketFormNameDto> getTicketForms() {
        return ticketFormService.getTicketFormsView();
    }

    @DeleteMapping("/{id}")
    void deleteTicketForm(@PathVariable Long id){
        ticketFormService.deleteTicketForm(id);
    }
}

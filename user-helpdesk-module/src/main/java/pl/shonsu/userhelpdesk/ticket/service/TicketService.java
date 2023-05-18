package pl.shonsu.userhelpdesk.ticket.service;

import org.springframework.stereotype.Service;
import pl.shonsu.userhelpdesk.ticket.controller.dto.TicketDtoRequest;
import pl.shonsu.userhelpdesk.ticket.controller.dto.TicketDtoResponse;
import pl.shonsu.userhelpdesk.ticket.model.Status;
import pl.shonsu.userhelpdesk.ticket.model.Ticket;
import pl.shonsu.userhelpdesk.ticket.repository.TicketRepository;
import pl.shonsu.userhelpdesk.user.model.HelpdeskUser;
import pl.shonsu.userhelpdesk.user.repository.HelpdeskUserRepository;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class TicketService {
    public static final int SERVICE_TIME_IN_DAYS = 3;

    private final TicketRepository ticketRepository;
    private final HelpdeskUserRepository helpdeskUserRepository;

    public TicketService(TicketRepository ticketRepository, HelpdeskUserRepository helpdeskUserRepository) {
        this.ticketRepository = ticketRepository;
        this.helpdeskUserRepository = helpdeskUserRepository;
    }

    public TicketDtoResponse createTicket(TicketDtoRequest ticketDtoRequest, String username) {
        HelpdeskUser helpdeskUser = helpdeskUserRepository.findByUsername(username);
        Ticket ticket = mapToTicket(ticketDtoRequest, helpdeskUser.getId(), Instant.now());
        ticket = ticketRepository.save(ticket);
        return mapTicketDtoResponse(ticket);
    }

    private static Ticket mapToTicket(TicketDtoRequest ticketDtoRequest, Long userId, Instant createDate) {
        return Ticket.builder()
                .status(Status.NEW)
                .creatorId(userId)
                .content(ticketDtoRequest.content())
                .createDate(createDate)
                .expiryDate(createDate.plus(SERVICE_TIME_IN_DAYS, ChronoUnit.DAYS))
                .build();
    }

    private TicketDtoResponse mapTicketDtoResponse(Ticket ticket) {
        return TicketDtoResponse.builder()
                .status(ticket.getStatus())
                .createDate(ticket.getCreateDate())
                .content(ticket.getContent())
                .build();

    }
}

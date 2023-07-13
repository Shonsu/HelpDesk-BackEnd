package pl.shonsu.userhelpdesk.ticketold.service;

import org.springframework.stereotype.Service;
import pl.shonsu.userhelpdesk.ticketold.controller.dto.TicketDtoRequest;
import pl.shonsu.userhelpdesk.ticketold.controller.dto.TicketDtoResponse;
import pl.shonsu.userhelpdesk.ticket.domain.adapter.out.persistance.entity.Status;
import pl.shonsu.userhelpdesk.ticket.domain.adapter.out.persistance.entity.TicketEntity;
import pl.shonsu.userhelpdesk.ticket.domain.adapter.out.persistance.repository.TicketEntityRepository;
import pl.shonsu.userhelpdesk.user.model.HelpdeskUser;
import pl.shonsu.userhelpdesk.user.repository.HelpdeskUserRepository;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class TicketService {
    public static final int SERVICE_TIME_IN_DAYS = 3;

    private final TicketEntityRepository ticketRepository;
    private final HelpdeskUserRepository helpdeskUserRepository;

    public TicketService(TicketEntityRepository ticketRepository, HelpdeskUserRepository helpdeskUserRepository) {
        this.ticketRepository = ticketRepository;
        this.helpdeskUserRepository = helpdeskUserRepository;
    }

    public TicketDtoResponse createTicket(TicketDtoRequest ticketDtoRequest, String username) {
        HelpdeskUser helpdeskUser = helpdeskUserRepository.findByUsername(username);
        TicketEntity ticket = mapToTicket(ticketDtoRequest, helpdeskUser.getId(), Instant.now());
        ticket = ticketRepository.save(ticket);
        return mapTicketDtoResponse(ticket);
    }

    private static TicketEntity mapToTicket(TicketDtoRequest ticketDtoRequest, Long userId, Instant createDate) {
        return TicketEntity.builder()
                .status(Status.NEW)
                .creatorId(userId)
                .contentEntity(ticketDtoRequest.content())
                .createDate(createDate)
                .expiryDate(createDate.plus(SERVICE_TIME_IN_DAYS, ChronoUnit.DAYS))
                .build();
    }

    private TicketDtoResponse mapTicketDtoResponse(TicketEntity ticket) {
        return TicketDtoResponse.builder()
                .status(ticket.getStatus())
                .createDate(ticket.getCreateDate())
                .content(ticket.getContentEntity())
                .build();

    }
}

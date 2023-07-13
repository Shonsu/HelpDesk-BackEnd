package pl.shonsu.userhelpdesk.ticketold.controller.dto;

import lombok.Builder;
import pl.shonsu.userhelpdesk.ticket.domain.adapter.out.persistance.entity.ContentEntity;
import pl.shonsu.userhelpdesk.ticket.domain.adapter.out.persistance.entity.Status;

import java.time.Instant;

@Builder
public record TicketDtoResponse(Instant createDate,
                                ContentEntity content,
                                Status status) {
}

package pl.shonsu.userhelpdesk.ticket.controller.dto;

import lombok.Builder;
import pl.shonsu.userhelpdesk.ticket.model.Content;
import pl.shonsu.userhelpdesk.ticket.model.Status;

import java.time.Instant;

@Builder
public record TicketDtoResponse(Instant createDate,
                                Content content,
                                Status status) {
}

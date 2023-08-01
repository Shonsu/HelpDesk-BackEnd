package pl.shonsu.userhelpdesk.ticketold.controller.dto;

import pl.shonsu.userhelpdesk.ticket.domain.adapter.out.persistance.entity.ContentEntity;

public record TicketDtoRequest(ContentEntity content) {
}

package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket;

import jakarta.persistence.EntityNotFoundException;
import pl.shonsu.userhelpdesk.ticket.domain.model.creator.CreatorId;
import pl.shonsu.userhelpdesk.ticket.domain.model.operator.OperatorId;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.*;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticketform.TicketFormId;
import pl.shonsu.userhelpdesk.ticket.domain.model.user.UserId;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.out.CreateTicketPort;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.out.LoadTicketPort;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.out.UpdateTicketPort;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.entity.TicketEntity;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.repository.TicketEntityRepository;

import static pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.TicketMapper.mapToTicketEntity;

public class TicketPersistenceAdapter implements CreateTicketPort, LoadTicketPort, UpdateTicketPort {
    private final TicketEntityRepository ticketEntityRepository;

    public TicketPersistenceAdapter(TicketEntityRepository ticketEntityRepository) {
        this.ticketEntityRepository = ticketEntityRepository;
    }

    @Override
    public void createTicket(Ticket ticket) {
        TicketEntity ticketEntity = mapToTicketEntity(ticket);
        ticketEntityRepository.save(ticketEntity);
    }

    @Override
    public Ticket loadTicket(TicketId ticketId) {
        TicketEntity ticket = ticketEntityRepository.findById(ticketId.id()).orElseThrow(
                () -> new EntityNotFoundException("Ticket [%s]not found.".formatted(ticketId.id())));
        TicketSnapshot ticketSnapshot = new TicketSnapshot(
                TicketId.of(ticket.getId()),
                CreatorId.of(ticket.getCreatorId()),
                OperatorId.of(ticket.getOperatorId()),
                CreatedAt.of(ticket.getCreateDate()),
                OpenedAt.of(ticket.getOpenDate()),
                TerminatedAt.of(ticket.getTerminateDate()),
                ExpiryAt.of(ticket.getExpiryDate()),
                new Content(TicketFormId.of(ticket.getContentEntity().getTicketFormId()), ticket.getContentEntity().getProperties()),
                TicketSnapshot.Status.valueOf(ticket.getStatus().name()),
                new ActionHistory(ticket.getActions().stream()
                        .map(actionEntity -> new Action(
                                Action.ActionId.of(actionEntity.getId()),
                                UserId.of(actionEntity.getUserId()),
                                Status.valueOf(actionEntity.getWhat().name()),
                                actionEntity.getDescription(),
                                actionEntity.getTimestamp(),
                                TicketId.of(actionEntity.getTicketEntityId())
                        )).toList())
        );
        return Ticket.from(ticketSnapshot);
    }

    @Override
    public void updateTicket(Ticket ticket) {
        TicketEntity ticketEntity = mapToTicketEntity(ticket);
        ticketEntity.getActions().forEach(System.out::println);
        TicketEntity save = ticketEntityRepository.save(ticketEntity);
    }
}

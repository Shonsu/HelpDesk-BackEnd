package pl.shonsu.userhelpdesk.ticket.infrastructure.application.service;

import jakarta.persistence.EntityNotFoundException;
import pl.shonsu.userhelpdesk.ticket.domain.model.ticket.TicketId;
import pl.shonsu.userhelpdesk.ticket.domain.model.user.UserId;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.TicketPresenterQuery;
import pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in.TicketViewResponse;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.repository.TicketEntityRepository;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.repository.dto.TicketEntityShortInfo;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticketform.entity.TicketFormEntity;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticketform.repository.TicketFormEntityRepository;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticketsubcategory.TicketSubCategoryEntityRepository;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticketsubcategory.entity.TicketSubCategoryEntity;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TicketPresenterService implements TicketPresenterQuery {
    private final TicketSubCategoryEntityRepository ticketSubCategoryEntityRepository;
    private final TicketEntityRepository ticketEntityRepository;
    private final TicketFormEntityRepository ticketFormEntityRepository;

    public TicketPresenterService(TicketSubCategoryEntityRepository ticketSubCategoryEntityRepository, TicketEntityRepository ticketEntityRepository, TicketFormEntityRepository ticketFormEntityRepository) {
        this.ticketSubCategoryEntityRepository = ticketSubCategoryEntityRepository;
        this.ticketEntityRepository = ticketEntityRepository;
        this.ticketFormEntityRepository = ticketFormEntityRepository;
    }

    @Override
    public TicketViewResponse getById(TicketId ticketId) {

        TicketEntityShortInfo ticketShortInfo = ticketEntityRepository.getTicketShortInfoById(ticketId.id())
                .orElseThrow(() -> new EntityNotFoundException("Ticket with %s id not found".formatted(ticketId.id())));
        TicketFormEntity ticketFormEntity = ticketFormEntityRepository.findById(ticketShortInfo.ticketFormId())
                .orElseThrow(() -> new EntityNotFoundException("TicketForm with %s id not found".formatted(ticketShortInfo.ticketFormId())));
        TicketSubCategoryEntity ticketSubCategory = ticketSubCategoryEntityRepository.findById(ticketFormEntity.getSubCategoryId())
                .orElseThrow(() -> new EntityNotFoundException("SubCategory with %s id not found".formatted(ticketFormEntity.getSubCategoryId())));
        String title = ticketSubCategory.getTicketCategory().getLabel() + "/" + ticketSubCategory.getLabel() + "/" + ticketFormEntity.getLabel();
        return new TicketViewResponse(ticketShortInfo.id(), title, ticketShortInfo.createdAt(), ticketShortInfo.status());
    }

    @Override
    public List<TicketViewResponse> getUserTickets2(UserId userId) {
        return ticketEntityRepository.getUserTickets(userId.id());
    }

    @Override
    public List<TicketViewResponse> getUserTickets(UserId userId) {

        List<TicketEntityShortInfo> userTickets = ticketEntityRepository.getUserAllTicketsShortInfo(userId.id());
        Set<Long> list = userTickets.stream().map(TicketEntityShortInfo::ticketFormId).collect(Collectors.toSet());

        List<TicketFormEntity> ticketForms = ticketFormEntityRepository.findByIdIn(list);
        Set<Long> subCategoryIds = ticketForms.stream().map(TicketFormEntity::getSubCategoryId).collect(Collectors.toSet());

        List<TicketSubCategoryEntity> subCategories = ticketSubCategoryEntityRepository.findByIdIn(subCategoryIds);

        List<TicketViewResponse> result = userTickets.stream()
                .map(ticket ->
                                ticketForms.stream()
                                        .filter(form -> form.getId().equals(ticket.ticketFormId()))
                                        .map(form -> subCategories.stream()
                                                        .filter(subCategory -> subCategory.getId().equals(form.getSubCategoryId()))
                                                        .map(subCategory ->
                                                                        new TicketViewResponse(ticket.id(),
//                                                        ticket.id() + "/" +
//                                                                ticket.ticketFormId() + "/" +
                                                                                subCategory.getTicketCategory().getLabel() + "/" +
                                                                                        subCategory.getLabel() + "/" +
                                                                                        form.getLabel(),
                                                                                ticket.createdAt(),
                                                                                ticket.status())
                                                        )
                                                        .toList()
                                        )
                                        .flatMap(Collection::stream)
                                        .toList()

                )
                .flatMap(Collection::stream)
                .toList();
        return result;
    }
}

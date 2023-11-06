package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticket.repository.dto.TicketEntityShortInfo;

import java.time.Instant;
import java.util.List;

@Entity(name = "ticket")
@Table(name = "ticket")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SqlResultSetMappings({@SqlResultSetMapping(
        name = "TicketEntityShortInfo",
        classes = {
                @ConstructorResult(
                        columns = {
                                @ColumnResult(name = "id"),
                                @ColumnResult(name = "ticketFormId"),
                                @ColumnResult(name = "createdAt"),
                                @ColumnResult(name = "status", type = Status.class),
                        },
                        targetClass = TicketEntityShortInfo.class
                )
        }
)})
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_generator")
    @SequenceGenerator(name = "ticket_generator", sequenceName = "ticket_id_seq", allocationSize = 1)
    private Long id;

    private Long creatorId;
    private Long operatorId;
    private Instant createDate;
    private Instant openDate;
    private Instant terminateDate;
    private Instant expiryDate;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "content")
    private ContentEntity contentEntity;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @JoinColumn(name = "ticket_id")
    private List<ActionEntity> actions;

    //TODO attachments names
}

package pl.shonsu.userhelpdesk.ticket.domain.adapter.out.persistance.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.List;

@Entity(name = "ticket")
@Table(name = "ticket")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_generator")
    @SequenceGenerator(name = "ticket_generator", sequenceName = "ticket_id_seq", allocationSize = 1)
    private Long id;

    private Long creatorId;
    private Instant createDate;
    private Instant expiryDate; //TODO add column to database table

    @JdbcTypeCode(SqlTypes.JSON)
    private ContentEntity contentEntity;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany
    private List<ActionEntity> actions;
    //TODO attachments names
    //TODO ticket history
    //TODO communication history

}

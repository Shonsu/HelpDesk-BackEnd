package pl.shonsu.userhelpdesk.ticket.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;

@Entity(name = "ticket")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_generator")
    @SequenceGenerator(name = "ticket_generator", sequenceName = "ticket_id_seq", allocationSize = 1)
    private Long id;

    private Long creatorId;
    private Long operatorId;
    private Instant createDate;
    private Instant expiryDate;

    @JdbcTypeCode(SqlTypes.JSON)
    private Content content;

    @Enumerated(EnumType.STRING)
    private Status status;

    //TODO attachments names
    //TODO ticket history
    //TODO communication history

}

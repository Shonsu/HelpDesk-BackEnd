package pl.shonsu.userhelpdesk.ticket.model;


import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;

@Entity(name = "ticket")
class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_generator")
    @SequenceGenerator(name = "ticket_generator", sequenceName = "ticket_id_seq", allocationSize = 1)
    private Long id;

    private Long userCreatorId;
    private LocalDateTime createDate;
    private LocalDateTime expiryDate;

    @JdbcTypeCode((SqlTypes.JSON))
    private Content content;

    @Enumerated(EnumType.STRING)
    private Status status;

    //TODO attachments names
    //TODO ticket history
    //TODO communication history

    public Long getId() {
        return id;
    }

    public Long getUserCreatorId() {
        return userCreatorId;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public Content getContent() {
        return content;
    }

    public Status getStatus() {
        return status;
    }
}

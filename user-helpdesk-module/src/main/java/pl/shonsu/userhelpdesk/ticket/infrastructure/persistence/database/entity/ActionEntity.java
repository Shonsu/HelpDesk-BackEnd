package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity(name = "`action`")
public class ActionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "action_generator")
    @SequenceGenerator(name = "action_generator", sequenceName = "action_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long userId;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status what;
    private String description;
    private Instant timestamp;
    @Column(name = "ticket_id")
    private Long ticketEntityId;

    public ActionEntity() {
    }

    public ActionEntity(Long id, Long userId, Status what, String description, Instant timestamp, Long ticketEntityId) {
        this.id = id;
        this.userId = userId;
        this.what = what;
        this.description = description;
        this.timestamp = timestamp;
        this.ticketEntityId = ticketEntityId;
    }

    public static ActionEntity withoutId(Long userId, Status what, String description, Instant timestamp, Long ticketEntityId) {
        return new ActionEntity(null, userId, what, description, timestamp, ticketEntityId);
    }

    public ActionEntity(Long userId, Status what, String description, Instant timestamp, Long ticketEntityId) {
        this(null, userId, what, description, timestamp, ticketEntityId);
    }

}


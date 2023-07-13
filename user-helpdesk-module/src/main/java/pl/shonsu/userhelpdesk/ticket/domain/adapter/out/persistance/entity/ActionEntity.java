package pl.shonsu.userhelpdesk.ticket.domain.adapter.out.persistance.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity(name = "action")
public class ActionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "action_generator")
    @SequenceGenerator(name = "action_generator", sequenceName = "action_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long userId;
    private Status what;
    private String description;
    private Instant timestamp;

    public ActionEntity() {
    }

    public ActionEntity(Long id, Long userId, Status what, String description, Instant timestamp) {
        this.id = id;
        this.userId = userId;
        this.what = what;
        this.description = description;
        this.timestamp = timestamp;
    }

    public static ActionEntity withoutId(Long userId, Status what, String description, Instant timestamp) {
        return new ActionEntity(null, userId, what, description, timestamp);
    }

    public ActionEntity(Long userId, Status what, String description, Instant timestamp) {
        this(null, userId, what, description, timestamp);
//        this.id = null;
//        this.userId = userId;
//        this.what = what;
//        this.description = description;
//        this.timestamp = timestamp;
    }

}


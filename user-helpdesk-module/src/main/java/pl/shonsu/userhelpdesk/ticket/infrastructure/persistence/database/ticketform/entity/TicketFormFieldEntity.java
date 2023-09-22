package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticketform.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Table(name = "ticket_form_field")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TicketFormFieldEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_form_field_generator")
    private Long id;

    @Column(name = "`key`")
    private String key;
    @OneToMany
    @JoinColumn(name = "ticket_form_field_id")
    @Fetch(FetchMode.SUBSELECT)
    private List<TicketFormFieldOptionEntity> ticketFormFieldOptionEntities;

}

package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticketform.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Table(name = "ticket_form")
@NamedEntityGraph()
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TicketFormEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_from_generator")
    private Long id;

    @OneToMany
    @JoinColumn(name = "ticket_form_id")
    @Fetch(FetchMode.SUBSELECT)
    private List<TicketFormFieldEntity> ticketFormFieldEntities;

}

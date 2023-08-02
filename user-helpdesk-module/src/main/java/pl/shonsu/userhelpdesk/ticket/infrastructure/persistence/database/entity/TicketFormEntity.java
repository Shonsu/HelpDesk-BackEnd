package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "ticket_form")
@Table(name = "ticket_form")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TicketFormEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_from_generator")
    //@SequenceGenerator(name = "ticket_form_generator", sequenceName = "ticket_form_id_sec", allocationSize = 1)
    private Long id;

    @OneToMany
    @JoinColumn(name = "ticket_form_id")
    private List<TicketFormFieldEntity> ticketFormFieldEntities;

}

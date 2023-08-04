package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "ticket_form_field")
@Entity(name = "ticket_form_field")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TicketFormFieldEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_form_field_generator")
    //@SequenceGenerator(name = "ticket_form_field_generator", sequenceName = "ticket_form_field_generator_id_sec", allocationSize = 1)
    private Long id;

    @Column(name = "`key`")
    private String key;
    @OneToMany
    @JoinColumn(name = "ticket_form_field_id")
    private List<TicketFormFieldOptionEntity> ticketFormFieldOptionEntities;

}

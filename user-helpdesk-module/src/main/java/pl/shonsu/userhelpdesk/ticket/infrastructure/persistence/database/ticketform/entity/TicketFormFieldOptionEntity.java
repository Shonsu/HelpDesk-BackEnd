package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticketform.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "ticket_form_field_option")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TicketFormFieldOptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_form_field_option_generator")
    private Long id;

    @Column(name = "`key`")
    private String key;

}

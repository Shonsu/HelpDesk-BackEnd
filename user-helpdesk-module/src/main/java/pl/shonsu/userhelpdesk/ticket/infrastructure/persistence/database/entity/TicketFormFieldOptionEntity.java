package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.entity;

import jakarta.persistence.*;

@Table(name = "ticket_form_field_option")
@Entity(name = "ticket_form_field_option")
class TicketFormFieldOptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_form_field_option_generator")
    //@SequenceGenerator(name = "ticket_form_field_option_generator", sequenceName = "ticket_form_field_option_generator_id_sec", allocationSize = 1)
    private Long id;

    @Column(name = "`key`")
    private String key;

}
package pl.shonsu.helpdesk.management.ticketform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.*;

@Table(name = "ticket_form_field_option")
@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TicketFormFieldOption {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_form_field_option_generator")
    @SequenceGenerator(name = "ticket_form_field_option_generator", sequenceName = "ticket_form_field_option_id_seq", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "`key`")
    private String key;
    private String value;
}

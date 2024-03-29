package pl.shonsu.helpdesk.management.ticketform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "ticket_form")
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketForm {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_form_generator")
    @SequenceGenerator(name = "ticket_form_generator", sequenceName = "ticket_form_id_seq", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String label;
    private Long subCategoryId;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, orphanRemoval = true)
    @JoinColumn(name = "ticket_form_id")
    private List<TicketFormField> ticketFormFields;

}

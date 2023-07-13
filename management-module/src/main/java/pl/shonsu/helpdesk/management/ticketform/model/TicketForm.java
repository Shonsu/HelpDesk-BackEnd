package pl.shonsu.helpdesk.management.ticketform.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

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

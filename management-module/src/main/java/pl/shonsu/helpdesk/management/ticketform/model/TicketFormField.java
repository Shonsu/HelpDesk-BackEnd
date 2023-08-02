package pl.shonsu.helpdesk.management.ticketform.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table(name = "ticket_form_field")
@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TicketFormField {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_form_field_generator")
    @SequenceGenerator(name = "ticket_form_field_generator", sequenceName = "ticket_form_field_id_seq", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "`key`")
    private String key;
    private String label;
    private boolean required;
    @Column(name = "`order`")
    private int order;
    @Enumerated(EnumType.STRING)
    private ControlType controlType;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, orphanRemoval = true)
    @JoinColumn(name = "ticket_form_field_id")
    private List<TicketFormFieldOption> options = new ArrayList<>();
    private String type;

    public void addOption(TicketFormFieldOption option) {
        if (options == null) {
            options = new ArrayList<>();
        }
        options.add(option);
    }
}

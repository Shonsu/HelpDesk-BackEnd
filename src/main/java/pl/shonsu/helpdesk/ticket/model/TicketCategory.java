package pl.shonsu.helpdesk.ticket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "ticket_category")
@Getter
class TicketCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_generator")
    @SequenceGenerator(name = "category_generator", sequenceName = "category_seq_id", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String label;
    private String description;
    @OneToMany
    @JoinColumn(name = "ticketCategoryId")
    private List<TicketSubCategory> subCategories;
}

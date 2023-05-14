package pl.shonsu.helpdesk.management.category.model;

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

@Entity
@Table(name = "ticket_category")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_category_generator")
    @SequenceGenerator(name = "ticket_category_generator", sequenceName = "ticket_category_id_seq", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String label;
    private String description;
    @OneToMany
    @JoinColumn(name = "ticketCategoryId")
    private List<TicketSubCategory> subCategories;
}

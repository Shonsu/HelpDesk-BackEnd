package pl.shonsu.helpdesk.management.category.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ticket_sub_category")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketSubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_sub_category_generator")
    @SequenceGenerator(name = "ticket_sub_category_generator", sequenceName = "ticket_sub_category_id_seq", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String label;
    private String description;
    private Long ticketCategoryId;
    //private Long supportedServiceId;
}

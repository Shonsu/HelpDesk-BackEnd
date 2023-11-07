package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticketsubcategory.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "ticket_sub_category")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class TicketSubCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_sub_category_generator")
    private Long id;
    private String label;
    @ManyToOne
    @JoinColumn(name = "ticketCategoryId")
    //@JoinColumn(foreignKey = @ForeignKey(name = "fk_ticket_sub_category_ticket_category_id"))
    private TicketCategoryEntity ticketCategory;
}

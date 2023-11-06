package pl.shonsu.userhelpdesk.ticket.infrastructure.persistence.database.ticketsubcategory.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "ticket_category")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class TicketCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_category_generator")
    private Long id;
    private String label;
}

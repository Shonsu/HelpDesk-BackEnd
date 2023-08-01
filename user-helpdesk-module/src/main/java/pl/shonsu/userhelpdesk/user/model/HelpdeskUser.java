package pl.shonsu.userhelpdesk.user.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "`user`")
@Getter
public class HelpdeskUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
   // @SequenceGenerator(name = "user_generator", sequenceName = "user_id_sec", allocationSize = 1)
    private Long id;
    String username;
}

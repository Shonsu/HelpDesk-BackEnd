package pl.shonsu.helpdesk.management.user.model;

import jakarta.persistence.*;

@Entity
@Table(name = "`user`")
public class UserManage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_id_seq", allocationSize = 1)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long handlingGroupId;

    public UserManage() {
        // for hibernate
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Long getHandlingGroupId() {
        return handlingGroupId;
    }


}

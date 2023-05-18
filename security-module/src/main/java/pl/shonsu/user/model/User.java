package pl.shonsu.user.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;

@Entity
@Table(name = "`user`")

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_id_seq", allocationSize = 1)
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    private String password;
    @Column(unique = true)
    private String email;
    private boolean enabled;

    @JdbcTypeCode(SqlTypes.JSON)
    private Authorities authorities;

    public User() {
        // for Hibernate
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Authorities getAuthorities() {
        return authorities;
    }
}

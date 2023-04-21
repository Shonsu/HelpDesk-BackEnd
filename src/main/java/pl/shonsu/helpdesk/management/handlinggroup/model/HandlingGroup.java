package pl.shonsu.helpdesk.management.department.model;

import jakarta.persistence.*;
import pl.shonsu.helpdesk.management.supportservice.model.SupportedService;

import java.util.Set;

@Entity
@Table(name = "handling_group")
public class HandlingGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_generator")
    @SequenceGenerator(name = "department_generator", sequenceName = "department_id_seq", allocationSize = 1)
    private Long id;
    private String name;

//    @OneToMany
//    private List<User> users;
    @ManyToMany
    @JoinTable(name = "handling_group_supported_service",
            joinColumns = @JoinColumn(name = "handling_group_id"),
            inverseJoinColumns = @JoinColumn(name = "supported_service_id"))
    private Set<SupportedService> supportedServices;



}

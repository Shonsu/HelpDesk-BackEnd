package pl.shonsu.helpdesk.management.handlinggroup.model;

import jakarta.persistence.*;
import pl.shonsu.helpdesk.management.supportedservice.model.SupportedService;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "handling_group")
public class HandlingGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "handling_group_generator")
    @SequenceGenerator(name = "handling_group_generator", sequenceName = "handling_group_id_seq", allocationSize = 1)
    private Long id;

    private String name;

    //    @OneToMany
//    private List<User> users;
    @ManyToMany
    @JoinTable(name = "handling_group_supported_service",
            joinColumns = @JoinColumn(name = "handling_group_id"),
            inverseJoinColumns = @JoinColumn(name = "supported_service_id"))
    private Set<SupportedService> supportedServices = new HashSet<>();


    protected HandlingGroup() {
    }

    public HandlingGroup(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addSupportedService(SupportedService supportedService) {
        this.supportedServices.add(supportedService);
        supportedService.getHandlingGroups().add(this);
    }

    public void removeSupportedService(SupportedService supportedService) {
        this.supportedServices.remove(supportedService);
        supportedService.getHandlingGroups().remove(this);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<SupportedService> getSupportedServices() {
        return supportedServices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HandlingGroup that = (HandlingGroup) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

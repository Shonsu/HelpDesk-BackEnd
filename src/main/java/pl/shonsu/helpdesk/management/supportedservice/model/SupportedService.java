package pl.shonsu.helpdesk.management.supportedservice.model;

import jakarta.persistence.*;
import pl.shonsu.helpdesk.management.handlinggroup.model.HandlingGroup;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "supported_service")
public class SupportedService {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supported_service_generator")
    @SequenceGenerator(name = "supported_service_generator", sequenceName = "supported_service_id_seq", allocationSize = 1)
    private Long id;
    private String code;

    @ManyToMany(mappedBy = "supportedServices")
    private Set<HandlingGroup> handlingGroups = new HashSet<>();

    protected SupportedService() {
    }

    public SupportedService(Long id, String code) {
        this.id = id;
        this.code = code;
    }

    public void addHandlingGroup(HandlingGroup handlingGroup) {
        this.handlingGroups.add(handlingGroup);
        handlingGroup.getSupportedServices().add(this);
    }

    public void removeHandlingGroup(HandlingGroup handlingGroup) {
        this.handlingGroups.remove(handlingGroup);
        handlingGroup.getSupportedServices().remove(this);
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public Set<HandlingGroup> getHandlingGroups() {
        return handlingGroups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupportedService that = (SupportedService) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

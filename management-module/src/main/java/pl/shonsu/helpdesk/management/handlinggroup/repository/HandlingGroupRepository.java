package pl.shonsu.helpdesk.management.handlinggroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shonsu.helpdesk.management.handlinggroup.model.HandlingGroup;

public interface HandlingGroupRepository extends JpaRepository<HandlingGroup, Long> {
    boolean existsByName(String name);
}

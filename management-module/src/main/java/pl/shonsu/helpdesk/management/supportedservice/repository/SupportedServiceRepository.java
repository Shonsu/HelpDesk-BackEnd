package pl.shonsu.helpdesk.management.supportedservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shonsu.helpdesk.management.supportedservice.model.SupportedService;


public interface SupportedServiceRepository extends JpaRepository<SupportedService,Long> {
    boolean existsByCode(String code);
}

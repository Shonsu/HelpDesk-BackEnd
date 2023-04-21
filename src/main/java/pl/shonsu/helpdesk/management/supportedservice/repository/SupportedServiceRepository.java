package pl.shonsu.helpdesk.management.supportservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shonsu.helpdesk.management.supportservice.model.SupportedService;


interface SupportServiceRepository extends JpaRepository<SupportedService,Long> {
}

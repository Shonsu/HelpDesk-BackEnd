package pl.shonsu.userhelpdesk.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shonsu.userhelpdesk.user.model.HelpdeskUser;

public interface HelpdeskUserRepository extends JpaRepository<HelpdeskUser, Long> {
    HelpdeskUser findByUsername(String username);
}

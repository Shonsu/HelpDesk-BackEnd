package pl.shonsu.helpdesk.management.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shonsu.helpdesk.management.user.model.User;

interface UserRepository extends JpaRepository<User, Long> {
}

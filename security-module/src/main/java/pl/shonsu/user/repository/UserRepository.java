package pl.shonsu.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shonsu.user.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
   Optional<User> findByUsername(String username);
}

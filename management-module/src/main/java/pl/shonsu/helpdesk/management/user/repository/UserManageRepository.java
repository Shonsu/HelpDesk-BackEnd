package pl.shonsu.helpdesk.management.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.shonsu.helpdesk.management.user.model.UserManage;

interface UserManageRepository extends JpaRepository<UserManage, Long> {
}

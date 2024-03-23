package online.hackpi.stall_rental_management_api.api.user.repository;

import online.hackpi.stall_rental_management_api.api.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
}

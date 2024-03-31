package online.hackpi.stall_rental_management_api.api.role.repository;

import online.hackpi.stall_rental_management_api.api.role.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByRoleName(String name);
    Role findByUuid(String uuid);
}

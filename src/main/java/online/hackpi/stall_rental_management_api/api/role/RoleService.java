package online.hackpi.stall_rental_management_api.api.role;

import online.hackpi.stall_rental_management_api.api.role.model.Role;
import online.hackpi.stall_rental_management_api.api.role.model.dto.RoleDto;

import java.util.List;


public interface RoleService {
    List<RoleDto> getAllRoles();
    RoleDto addNewRole(Role role);
    Role searchRoleByRoleName(String name);
}

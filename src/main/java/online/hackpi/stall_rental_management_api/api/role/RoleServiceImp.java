package online.hackpi.stall_rental_management_api.api.role;

import lombok.RequiredArgsConstructor;
import online.hackpi.stall_rental_management_api.api.role.mapstruct.RoleMapper;
import online.hackpi.stall_rental_management_api.api.role.model.Role;
import online.hackpi.stall_rental_management_api.api.role.model.dto.RoleDto;
import online.hackpi.stall_rental_management_api.api.role.repository.RoleRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleServiceImp implements RoleService{
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    @Override
    public List<RoleDto> getAllRoles() {
        return roleMapper.mapFromListOfRoleToListOfRoleDto(roleRepository.findAll());
    }
    @Override
    public RoleDto addNewRole(Role role) {
        role.setUuid(UUID.randomUUID().toString());
        role.setDescription("This is the role for authorise each user in system");
        return roleMapper.mapFromRoleToRoleDto(roleRepository.save(role));
    }

    @Override
    public Role searchRoleByRoleName(String name) {
        return roleRepository.findRoleByRoleName(name);
    }
}

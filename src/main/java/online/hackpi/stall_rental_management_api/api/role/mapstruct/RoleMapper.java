package online.hackpi.stall_rental_management_api.api.role.mapstruct;

import online.hackpi.stall_rental_management_api.api.role.model.Role;
import online.hackpi.stall_rental_management_api.api.role.model.dto.RoleDto;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    List<RoleDto> mapFromListOfRoleToListOfRoleDto(List<Role> roleList);
    RoleDto mapFromRoleToRoleDto(Role role);
    Set<RoleDto> mapFromSetOfRoleToSetOfRoleDto(Set<Role> roleHashSet);
}

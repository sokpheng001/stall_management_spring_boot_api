package online.hackpi.stall_rental_management_api.api.role.model.dto;

import lombok.Builder;

@Builder
public record RoleDto(
        String uuid,
        String roleName,
        String description
) {
}

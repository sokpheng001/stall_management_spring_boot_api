package online.hackpi.stall_rental_management_api.api.user.model.dto;

import jakarta.validation.constraints.Email;
import lombok.Builder;
import online.hackpi.stall_rental_management_api.api.role.model.Role;
import online.hackpi.stall_rental_management_api.api.role.model.dto.RoleDto;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Builder
public record UserDto(
        String uuid,
        String userName,
        @Email
        String email,
        Integer phoneNumber,
        String address,
        String bio,
        String profileImage,
        LocalDate dateOfBirth,
        LocalDate createdAt,
        Boolean isDeleted,
        Set<Role> roles
) {
}

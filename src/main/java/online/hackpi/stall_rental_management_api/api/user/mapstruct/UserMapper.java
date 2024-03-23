package online.hackpi.stall_rental_management_api.api.user.mapstruct;

import online.hackpi.stall_rental_management_api.api.role.model.Role;
import online.hackpi.stall_rental_management_api.api.role.model.dto.RoleDto;
import online.hackpi.stall_rental_management_api.api.user.model.User;
import online.hackpi.stall_rental_management_api.api.user.model.dto.UserDto;
import org.mapstruct.Mapper;

import java.util.HashSet;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    List<UserDto> mapFromListOfUserToListOfUserDto(List<User> userList);
    UserDto mapFromUserToUserDto(User user);

}

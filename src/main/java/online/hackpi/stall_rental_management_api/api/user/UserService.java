package online.hackpi.stall_rental_management_api.api.user;

import online.hackpi.stall_rental_management_api.api.user.model.User;
import online.hackpi.stall_rental_management_api.api.user.model.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto addNewUser(User user);
}

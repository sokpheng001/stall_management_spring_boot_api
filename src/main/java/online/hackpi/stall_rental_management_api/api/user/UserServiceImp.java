package online.hackpi.stall_rental_management_api.api.user;

import lombok.RequiredArgsConstructor;
import online.hackpi.stall_rental_management_api.api.role.RoleService;
import online.hackpi.stall_rental_management_api.api.role.model.Role;
import online.hackpi.stall_rental_management_api.api.user.mapstruct.UserMapper;
import online.hackpi.stall_rental_management_api.api.user.model.User;
import online.hackpi.stall_rental_management_api.api.user.model.dto.UserDto;
import online.hackpi.stall_rental_management_api.api.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleService roleService;
    @Override
    public List<UserDto> getAllUsers() {
        System.out.println(userRepository.findAll());
        return userMapper.mapFromListOfUserToListOfUserDto(userRepository.findAll());
    }
    @Override
    public UserDto addNewUser(User user_) {
        user_.setUuid(UUID.randomUUID().toString());
        user_.setCreatedAt(LocalDate.now());
        User user = user_;
//        Set<Role> roleHashSet = new HashSet<>();
        user_.getRoles().stream()
                .map(e-> roleService.searchRoleByRoleName(e.getRoleName())
                ).forEach(role -> {
                    user.getRoles().add(role);
                });
        return userMapper.mapFromUserToUserDto(userRepository.save(user));
//        return null;
    }
}

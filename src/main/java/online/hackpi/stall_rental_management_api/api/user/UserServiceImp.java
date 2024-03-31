package online.hackpi.stall_rental_management_api.api.user;

import lombok.RequiredArgsConstructor;
import online.hackpi.stall_rental_management_api.api.role.RoleService;
import online.hackpi.stall_rental_management_api.api.role.model.Role;
import online.hackpi.stall_rental_management_api.api.role.repository.RoleRepository;
import online.hackpi.stall_rental_management_api.api.user.mapstruct.UserMapper;
import online.hackpi.stall_rental_management_api.api.user.model.User;
import online.hackpi.stall_rental_management_api.api.user.model.dto.UserDto;
import online.hackpi.stall_rental_management_api.api.user.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleService roleService;
    private final RoleRepository roleRepository;
    @Override
    public List<UserDto> getAllUsers() {
        System.out.println(userRepository.findAll());
        return userMapper.mapFromListOfUserToListOfUserDto(userRepository.findAll());
    }
    @Override
    public UserDto addNewUser(User user) {
        user.setUuid(UUID.randomUUID().toString());
        Set<Role> roleSet = new HashSet<>();
        user.getRoles().forEach(e->{
            roleSet.add(roleRepository.findByUuid(e.getUuid()));
        });
        user.getRoles().clear();
        for(Role role: roleSet){
            user.getRoles().add(role);
        }
        System.out.println(user.getRoles());
        return userMapper.mapFromUserToUserDto(userRepository.save(user));
//        return null;
    }
}

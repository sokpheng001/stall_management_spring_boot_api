package online.hackpi.stall_rental_management_api.api.user;

import lombok.RequiredArgsConstructor;
import online.hackpi.stall_rental_management_api.api.user.model.User;
import online.hackpi.stall_rental_management_api.api.user.model.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserRestController {
    private final UserService userService;
    @GetMapping("")
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getAllUsers());
    }
    @PostMapping("/add-new")
    public ResponseEntity<?> addNewUser(@RequestBody User user){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.addNewUser(user));
    }
}

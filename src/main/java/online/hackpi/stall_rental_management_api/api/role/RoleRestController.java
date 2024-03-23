package online.hackpi.stall_rental_management_api.api.role;

import lombok.RequiredArgsConstructor;
import online.hackpi.stall_rental_management_api.api.role.model.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleRestController {
    private final RoleService roleService;
    @GetMapping("")
    public ResponseEntity<?> getAllRoles(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(roleService.getAllRoles());
    }
    @PostMapping("/add-new")
    public ResponseEntity<?> addNewRole(@RequestBody Role role){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(roleService.addNewRole(role));
    }
    @GetMapping("/")
    public ResponseEntity<?> findRoleByRoleName(@RequestParam(value = "name") String name){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(roleService.searchRoleByRoleName(name));
    }
}

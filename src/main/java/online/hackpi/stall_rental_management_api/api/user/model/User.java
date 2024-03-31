package online.hackpi.stall_rental_management_api.api.user.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import online.hackpi.stall_rental_management_api.api.role.model.Role;
import org.hibernate.Hibernate;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@RequiredArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String userName;
    @Email
    private String email;
    private String password;
    @Positive
    private String phoneNumber;
    private String address;
    private String bio;
    private String profileImage;
    private LocalDate dateOfBirth;
    private LocalDate createdAt;
    private Boolean isDeleted;
    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();
    public Set<Role> getRoles(){
        if(!Hibernate.isInitialized(roles)){
            Hibernate.initialize(roles);
        }
        return roles;
    }
}

package online.hackpi.stall_rental_management_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("online.hackpi.stall_rental_management_api.api.role.mapstruct")
public class StallRentalManagementApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(StallRentalManagementApiApplication.class, args);
    }

}

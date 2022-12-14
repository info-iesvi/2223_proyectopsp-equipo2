package org.iesvi.isara;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application, based on Spring Boot, where the service starts.
 *
 * @author Isa González & Sara Palma
 */
@SpringBootApplication
public class IsaraApplication {
    public static void main(String[] args) {
        SpringApplication.run(IsaraApplication.class, args);
    }
}

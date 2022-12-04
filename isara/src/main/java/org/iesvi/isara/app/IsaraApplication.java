package org.iesvi.isara.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application, based on Spring Boot, where the service starts.
 *
 * @author Isa González
 */
@SpringBootApplication
public class IsaraApplication {

    public static void main(String[] args) {
        SpringApplication.run(IsaraApplication.class, args);
    }

}

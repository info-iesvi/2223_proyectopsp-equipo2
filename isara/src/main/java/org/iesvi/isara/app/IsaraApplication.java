package org.iesvi.isara.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Main application, based on Spring Boot, where the service starts.
 *
 * @author Isa González
 */
@SpringBootApplication
@ComponentScan({ "org.iesvi.isara.userManagement.infra.dto.converter" })
@EntityScan({"org.iesvi.isara.shared.domain", "org.iesvi.isara.userManagement.domain"})
@EnableJpaRepositories({"org.iesvi.isara.userManagement.infra.persistence", "org.iesvi.isara.shared.infra.persistence"})
public class IsaraApplication {
    public static void main(String[] args) {
        SpringApplication.run(IsaraApplication.class, args);
    }
}

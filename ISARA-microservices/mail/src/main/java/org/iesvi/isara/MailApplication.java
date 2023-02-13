package org.iesvi.isara;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.iesvi.isara.service.MailService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@AllArgsConstructor
public class MailApplication implements CommandLineRunner {

    private final MailService mailService;

    public static void main(String[] args) {
        SpringApplication.run(MailApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        mailService.sendEmail("sara.palmarodriguez@iesvalleinclan.es", "Prueba 1", "¡Hola!");
    }
}

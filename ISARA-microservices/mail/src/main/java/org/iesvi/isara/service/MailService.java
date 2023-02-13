package org.iesvi.isara.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class MailService {

    private final JavaMailSender mail;

    public void sendEmail(String receiver, String title, String message) {
        log.info("Enviando email simples");

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(receiver);
        email.setCc("isabelmariagonzalezrodriguez@gmail.com");
        email.setSubject(title);
        email.setText(message);

        log.info("Email enviado con éxito!");
    }

    public void sendEmailWithFile(String title, String receiver, String message, String file) throws MessagingException {
        log.info("Enviando email con archivo");
        MimeMessage mimeMessage = mail.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setTo(receiver);
        helper.setSubject(title);
        helper.setText(message, true);
        helper.addAttachment("image1.jpg", new ClassPathResource(file));

        mail.send(mimeMessage);
        log.info("Email con archivo enviado con éxito");
    }
}

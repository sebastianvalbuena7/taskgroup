package com.sebastian.taskgroup.infrastructure.helper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class EmailHelper {
    private final JavaMailSender javaMailSender;

    public void sendMail(String to, String name) {
        MimeMessage message = javaMailSender.createMimeMessage();
        String htmlContent = readHTMLTemplate(name);

        try {
            message.setFrom(new InternetAddress("sebastianvalbuena25@gmail.com"));
            message.setSubject("Account Created");
            message.setRecipients(MimeMessage.RecipientType.TO, to);
            message.setContent(htmlContent, MediaType.TEXT_HTML_VALUE);
            javaMailSender.send(message);
        } catch (MessagingException messagingException) {
            throw new RuntimeException();
        }
    }

    private String readHTMLTemplate(String name) {
        try(var lines = Files.lines(TEMPLATE_PATH)) {
            var html = lines.collect(Collectors.joining());
            return html.replace("{name}", name);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private final Path TEMPLATE_PATH = Paths.get("src/main/resources/email/email_template.html");
}
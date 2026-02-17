package com.Gaurav.wed.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendFeedbackEmail(String name, String email, String comment) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo("gaurav.eeepatna@gmail.com");
        message.setFrom("gaurav.eeepatna@gmail.com");   // must be same as SMTP username
        message.setReplyTo(email);

        message.setSubject("New Wedding Feedback from " + name);

        message.setText("Name: " + name + "\nEmail: " + email + "\nComment: " + comment);

        mailSender.send(message);
    }
}

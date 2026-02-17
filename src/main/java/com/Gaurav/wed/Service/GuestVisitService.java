package com.Gaurav.wed.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.Gaurav.wed.Repository.GuestVisitRepository;
import com.Gaurav.wed.entity.GuestVisit;


@Service
public class GuestVisitService {

    @Autowired
    private GuestVisitRepository guestVisitRepository;

    @Autowired
    private JavaMailSender mailSender;

    public void saveGuestVisitAndSendMail(String name, String email, String comment) {

        // ✅ Save into DB
        GuestVisit guestVisit = new GuestVisit();
        guestVisit.setName(name);
        guestVisit.setEmail(email);
        guestVisit.setComment(comment);

        guestVisitRepository.save(guestVisit);

        // ✅ Send Email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("gaurav.eeepatna@gmail.com");   // receiver
        message.setFrom("gaurav.eeepatna@gmail.com"); // must match spring.mail.username
        message.setReplyTo(email);

        message.setSubject("💍 New Wedding Comment from " + name);

        message.setText(
                "New Guest Comment Received\n\n" +
                "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Comment: " + comment + "\n\n" +
                "Regards,\nWedding Website"
        );

        mailSender.send(message);
    }
}

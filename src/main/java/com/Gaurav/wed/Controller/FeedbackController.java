package com.Gaurav.wed.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Gaurav.wed.DTO.FeedbackRequest;
import com.Gaurav.wed.Repository.GuestVisitRepository;
import com.Gaurav.wed.Service.EmailService;
import com.Gaurav.wed.entity.GuestVisit;


@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private GuestVisitRepository guestVisitRepository;

    @PostMapping
    public ResponseEntity<String> sendFeedback(@RequestBody FeedbackRequest request) {

        // ✅ Save in DB (guest_visit table)
        GuestVisit guestVisit = new GuestVisit();
        guestVisit.setName(request.getName());
        guestVisit.setEmail(request.getEmail());
        guestVisit.setComment(request.getComment()); // make sure comment field added in entity

        guestVisitRepository.save(guestVisit);

        // ✅ Send Email
        emailService.sendFeedbackEmail(
                request.getName(),
                request.getEmail(),
                request.getComment()
        );

        return ResponseEntity.ok("Feedback saved in DB and mail sent successfully");
    }
}

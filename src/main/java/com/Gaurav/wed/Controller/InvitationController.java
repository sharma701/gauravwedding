package com.Gaurav.wed.Controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Gaurav.wed.Repository.GuestVisitRepository;
import com.Gaurav.wed.entity.GuestVisit;

@Controller
public class InvitationController {

    private final GuestVisitRepository repository;



    // Constructor Injection (Best Practice)

    public InvitationController(GuestVisitRepository repository) {

        this.repository = repository;

    }



    // 🔹 Optional Root Mapping (Recommended)

    @GetMapping("/")
    public String rootRedirect() {
        return "redirect:/gaurav";

    }

    @GetMapping("/gaurav")
    public String home() {

        return "index";   // index.jsp

    }

    @PostMapping("/welcome")
    public String welcome(@RequestParam("name") String name, Model model) {
        GuestVisit guest = new GuestVisit();
        guest.setName(name);
        guest.setVisitTime(LocalDateTime.now());
        repository.save(guest);
        model.addAttribute("guestName", name);

        return "welcome";  // welcome.jsp

    }


    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("guests", repository.findAll());
        return "admin";   // admin.jsp

    }


    @GetMapping("/functions")
    public String functions() {
        return "function-details";

    }

    @GetMapping("/tilak")
    public String tilak() {
        return "tilak";

    }

    @GetMapping("/mehendi")
    public String mehendi() {
        return "mehendi";
    }


    @GetMapping("/details")
    public String details() {
        return "details";
    }

    @GetMapping("/wedding")
    public String wedding() {
        return "wedding";

    }


    @GetMapping("/closing")
    public String closing() {
        return "closing";

    }

    @Autowired
    private JavaMailSender mailSender;

    private void sendFeedbackEmail(String name, String email, String comment) {
    	try {
    	    SimpleMailMessage message = new SimpleMailMessage();

    	    message.setTo("gaurav.eeepatna@gmail.com");   // admin mail (receiver)

    	    message.setFrom("gaurav.eeepatna@gmail.com"); // SAME as spring.mail.username

    	    message.setReplyTo(email);  // user email (optional but best)

    	    message.setSubject("New Wedding Feedback from " + name);

    	    message.setText("Name: " + name + "\nEmail: " + email + "\nComment: " + comment);

    	    mailSender.send(message);

    	} catch (Exception e) {
    	    e.printStackTrace();
    	}

    }
}


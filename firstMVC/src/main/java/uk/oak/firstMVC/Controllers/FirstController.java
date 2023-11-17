package uk.oak.firstMVC.Controllers;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {

    private final JavaMailSender javaMailSender;

    public FirstController(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @RequestMapping("/first")
    public String home() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("oak@oak.com");
        simpleMailMessage.setCc("oakacademy@oak.com");
        simpleMailMessage.setText("This mail send by OAK academy");
        simpleMailMessage.setSubject("TestMail");
        javaMailSender.send(simpleMailMessage);
        return "index.html";
    }


    public void sendmail() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("oak@oak.com");
        simpleMailMessage.setCc("oakacademy@oak.com");
        simpleMailMessage.setText("This mail send by OAK academy");
        simpleMailMessage.setSubject("TestMail");
        javaMailSender.send(simpleMailMessage);

    }


}

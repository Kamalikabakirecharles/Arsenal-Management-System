package com.WebtecFinalProject.Controller;

import com.WebtecFinalProject.Model.Rank;
import com.WebtecFinalProject.Model.Soldier;
import com.WebtecFinalProject.Service.SoldierService;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.Property;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Properties;

@Controller
public class SoldierController {
    @Autowired
    SoldierService soldierService;

    @GetMapping("/soldier")
    public String soldier(Model model){
        model.addAttribute("soldierModel",new Soldier());
        model.addAttribute("rank", Rank.values());
        return "Soldier";
    }

//    @PostMapping("createSoldier")
//    public String createSoldier(@ModelAttribute("soldierModel") Soldier soldier){
//        soldierService.createSoldier(soldier);
//        return "redirect:/dash";
//    }

    @PostMapping("createSoldier")
    public String createSoldier(@ModelAttribute("soldierModel") Soldier soldier) {
        soldierService.createSoldier(soldier);

        // Sending email after creating soldier
        String recipient = soldier.getEmail();
        String message = "<strong>Thank you for signing up.</strong><br>"
                + "<strong>Rank:</strong> " + soldier.getRank() + "<br>"
                + "<strong>MilitaryNumber:</strong> " + soldier.getMilitaryNumber() + "<br>"
                + "<strong>Username:</strong> " + soldier.getUsername() + "<br>"
                + "<strong>Password:</strong> " + soldier.getPassword();
        // Assuming the SendMail method returns a redirect URL
        return SendMail(recipient, message);
    }

    public String SendMail(String recipient, String messageBody) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        final String senderEmail = "kmlcharles@gmail.com";
        final String senderPassword = "ozvs rvkx oijg ngvr";

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject("This Email Is To Give You Login Info");

            // Create a MimeBodyPart to represent the message body
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(messageBody, "text/html");

            // Create a Multipart object to hold the body parts
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // Set the content of the message to be the multipart object
            message.setContent(multipart);

            // Send the message
            Transport.send(message);

            return "redirect:/dash";

        } catch (MessagingException e) {
            e.printStackTrace();
            return null;
        }
    }

}

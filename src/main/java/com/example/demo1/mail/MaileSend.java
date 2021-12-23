package com.example.demo1.mail;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.example.demo1.model.Client;
import javafx.beans.property.Property;

import java.util.Properties;

public class MaileSend {


    public static void sendMail(String to_mail,String subject,Client client,String entity) throws Exception{


        Properties properties = new Properties();

        // Recipient's email ID needs to be mentioned.
        String to = to_mail;

        // Sender's email ID needs to be mentioned
        String from = "data.formation.consulting@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("exampl@gmail.com", "*****************");

            }

        });

        Message message = prepareMessage(session,from,to,subject,client,entity );

        if (message != null){
            Transport.send(message);
            System.out.println("Sent message successfully....");
        }else{
            System.out.println("Mail not sending");
        }


    }

    private static Message prepareMessage(Session session, String from, String to, String subject, Client client,String entity) {
        // Used to debug SMTP issues
        //session.setDebug(true);
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            message.setContent(
                    "<h1>This email from Centralized Mutual</h1>" +
                            " Your complet name : "+client.getFirstname()+"  "+client.getLastname()+
                            "<br/> Your identity is : "+client.getCin() +
                            "<br/> Your Badge number is : "+client.getBadgenumber()+
                            "<br/> You work in company : "+client.getCompanyName()+
                            "<br/> You register in Entity : "+entity,
                    "text/html");

            System.out.println("sending...");
            // Send message



            return message;
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

        return null;
    }
}

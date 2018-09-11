package com.reg.login.forgot;

import java.io.IOException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import java.io.File;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class MailImpl {
	public  void send(String to,String name) {
		  Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", "smtp.gmail.com");
	      props.put("mail.smtp.port", "587");
	      props.put("mail.debug", "true");
	      Session session = Session.getInstance(props,
	  		  new Authenticator() {
	  			protected PasswordAuthentication getPasswordAuthentication() {
	  				return new PasswordAuthentication("ouroffice143@gmail.com", "ouroffice@143");
	  			}
	  		  });
	    
	       try {
		        MimeMessage msg = new MimeMessage(session);
		        msg.setFrom(new InternetAddress("ouroffice143@gmail.com"));
		        msg.setRecipients(Message.RecipientType.TO, "srujanreddy595@gmail.com");
		        msg.setSubject("Html Test Mail with Attachement");
		        msg.setSentDate(new Date());
		        
		        Multipart multipart = new MimeMultipart();
		        
		        MimeBodyPart htmlPart = new MimeBodyPart();
		        String htmlContent = "<html><body><a href=http://localhost:9090/emp/Login.html></a></body></html>";
		        htmlPart.setContent(htmlContent, "text/html");
		        multipart.addBodyPart(htmlPart);
		        
		       
		        
		        msg.setContent(multipart);
		        Transport.send(msg);
		        System.out.println("---Done---");
	       } catch (Exception ex) {
	    	    ex.printStackTrace();
	       }
	}
} 
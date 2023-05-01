package com.exam.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
   
	public void sendEmail(String subject,String message,String to) 
	{
		
		String from="annanyasharma19@gnu.ac.in";
		String host="smtp.gmail.com";//simple mail transfer protocol
	     
	     //get the system properties
	     Properties properties=System.getProperties();
	     System.out.println("Properties"+properties);
	     //setting imp info to properties object
	     properties.put("mail.smtp.host", host);//(key,value) pair
	     properties.put("mail.smtp.port", "465");
	     properties.put("mail.smtp.ssl.enable", "true");
	     properties.setProperty("mail.smtp.auth", "true"); 
	     
	     //step1:to get the session object
	     Session session=Session.getInstance(properties, new Authenticator() {
//
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("annanyasharma19@gnu.ac.in","9426984396");
			}
	    	 
		});
	     
	     //step 2 : compose the message 
	     MimeMessage m= new MimeMessage(session);
	     try {
	     //set from email id
	     m.setFrom(from);
	     //recipient to message
	     m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	     
	     //adding subject to message 
	     m.setSubject(subject);
	     
	     //adding  text to message 
	    // m.setText(message);
	     m.setContent(message,"text/html");
	     
	     //send the message using transport class
	     Transport.send(m);
	     Transport transport = session.getTransport("smtp");
	     System.out.println("Message sent successfully");
	     
	     
	     }
	     catch(Exception e) {
	    	 e.printStackTrace();
	     }

	}
}

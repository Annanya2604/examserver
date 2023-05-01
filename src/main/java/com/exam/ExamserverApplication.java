package com.exam;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

//@EntityScan(basePackages = { "com.springboot.entities" })
public class ExamserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
//		String message="Please attempt the quiz .The quiz is of 1 hour,you won't be able to submit your response after the given "
//				+ "time limit";
//		String subject="details regarding exam";
//		String to="annanyasharma3401@gmail.com";
//		//String to="pateltanvi2482001@gmail.com";
//		String from="annanyasharma19@gnu.ac.in";
//		sendEmail(message,subject,to,from);

	}
	//this method is responsible to send email
//	private static void sendEmail(String message, String subject, String to, String from)  {
////			//variable for gmail host
//		     String host="smtp.gmail.com";//simple mail transfer protocol
//		     
//		     //get the system properties
//		     Properties properties=System.getProperties();
//		     System.out.println("Properties"+properties);
//		     //setting imp info to properties object
//		     properties.put("mail.smtp.host", host);//(key,value) pair
//		     properties.put("mail.smtp.port", "465");
//		     properties.put("mail.smtp.ssl.enable", "true");
//		     properties.setProperty("mail.smtp.auth", "true"); 
//		     
//		     //step1:to get the session object
//		     Session session=Session.getInstance(properties, new Authenticator() {
//	//
//				@Override
//				protected PasswordAuthentication getPasswordAuthentication() {
//					// TODO Auto-generated method stub
//					return new PasswordAuthentication("annanyasharma19@gnu.ac.in","9426984396");
//				}
//		    	 
//			});
//		     
//		     //step 2 : compose the message 
//		     MimeMessage m= new MimeMessage(session);
//		     try {
//		     //set from email id
//		     m.setFrom(from);
//		     //recipient to message
//		     m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//		     
//		     //adding subject to message 
//		     m.setSubject(subject);
//		     
//		     //adding  text to message 
//		     m.setText(message);
//		     
//		     //send the message using transport class
//		     Transport.send(m);
//		     Transport transport = session.getTransport("smtp");
//		     System.out.println("Message sent successfully");
//		     
//		     
//		     }
//		     catch(Exception e) {
//		    	 e.printStackTrace();
//		     }
//			
//		}
//
//
//	
	

@Bean	
 public ModelMapper modelMapper() {
	 return new ModelMapper();
 }
}

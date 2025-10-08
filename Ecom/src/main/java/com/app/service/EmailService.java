package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class EmailService {
	
	private JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


	public  boolean send(String to, String from, String subject, String text) {
		
		 boolean sent = false;


	        try {

	        	SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
	            simpleMailMessage.setFrom(from);
	            simpleMailMessage.setTo(to);
	            simpleMailMessage.setSubject(subject);
	            simpleMailMessage.setText(text);

	            // send
	            javaMailSender.send(simpleMailMessage);
	            sent = true;

	        } catch (Exception e) {
	            e.printStackTrace();
	        }


	        return sent;
	}
}

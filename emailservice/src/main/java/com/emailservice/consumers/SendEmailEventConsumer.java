package com.emailservice.consumers;

import com.emailservice.dtos.EmailDto;
import com.emailservice.utills.EmailUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

@Component

public class SendEmailEventConsumer {
	ObjectMapper objectMapper;

	public SendEmailEventConsumer(ObjectMapper objectMapper){
		this.objectMapper = objectMapper;
	}

	@KafkaListener(topics = "sendEmail", groupId = "emailService")
	public void listenSendEmailEvent(String message){
		try {
			EmailDto sendEmailEvent = objectMapper.readValue(message, EmailDto.class);

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true"); //enable authentication
			props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
			props.put("mail.smtp.port", "587"); //TLS Port
			props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

			Authenticator auth = new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("it8131995@gmail.com", "9560431469");
				}

			};

			Session session = Session.getInstance(props, auth);

			EmailUtil.sendEmail(session, sendEmailEvent.getTo(), sendEmailEvent.getSubject(), sendEmailEvent.getBody());
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}

	}
}

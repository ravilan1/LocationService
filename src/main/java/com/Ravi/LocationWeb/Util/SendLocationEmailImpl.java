package com.Ravi.LocationWeb.Util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class SendLocationEmailImpl implements ISendLocationEmail {

	@Autowired
	JavaMailSender jmSender;
	
	@Override
	public void sendLocationEmail(String sendto, String subject, String body) {
		MimeMessage mmMessage = jmSender.createMimeMessage();
		MimeMessageHelper mmHelper = new MimeMessageHelper(mmMessage);
		try {
			mmHelper.setTo(sendto);
			mmHelper.setSubject(subject);
			mmHelper.setText(body);
			jmSender.send(mmMessage);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package com.myrni.serviceImpl;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.myrni.requestVo.EmailRequestVO;
import com.myrni.service.NotificationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

	private final JavaMailSender mailSender;


	@Override
	public void sendEmail(EmailRequestVO requestVO) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(requestVO.getToEmail());

		message.setSubject(requestVO.getSubject());

		message.setText(requestVO.getMessage());

		mailSender.send(message);

	}
}
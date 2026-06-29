package com.myrni.service;

import com.myrni.requestVo.EmailRequestVO;

public interface NotificationService {

	void sendEmail(EmailRequestVO requestVO);
	
}
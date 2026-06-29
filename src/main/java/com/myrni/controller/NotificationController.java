package com.myrni.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.myrni.requestVo.EmailRequestVO;
import com.myrni.service.NotificationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

	private final NotificationService notificationService;

	@PostMapping("/email")
	public ResponseEntity<String> sendEmail(@RequestBody EmailRequestVO requestVO) {

		notificationService.sendEmail(requestVO);

		return ResponseEntity.ok("Email sent successfully");
	}
}
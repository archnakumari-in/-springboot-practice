package com.myrni.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myrni.requestVo.LoginRequestVO;
import com.myrni.responsVO.LoginResponseVO;
import com.myrni.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

	@PostMapping("/login")
	public ResponseEntity<LoginResponseVO> login(@RequestBody LoginRequestVO requestVO) {

		return ResponseEntity.ok(authService.login(requestVO));
	}

}

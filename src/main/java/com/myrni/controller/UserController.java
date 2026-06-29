package com.myrni.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myrni.requestVo.UserRequestVO;
import com.myrni.responsVO.UserResponseVO;
import com.myrni.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping("/register")
	public ResponseEntity<UserResponseVO> registerUser(@RequestBody UserRequestVO requestVO) {

		return new ResponseEntity<>(userService.registerUser(requestVO), HttpStatus.CREATED);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserResponseVO> getUserById(@PathVariable Long userId) {

		return ResponseEntity.ok(userService.getUserById(userId));
	}

	@GetMapping
	public ResponseEntity<List<UserResponseVO>> getAllUsers() {

		return ResponseEntity.ok(userService.getAllUsers());
	}

}

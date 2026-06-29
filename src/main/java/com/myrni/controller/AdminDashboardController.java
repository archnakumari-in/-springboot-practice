package com.myrni.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myrni.responsVO.AdminDashboardResponseVO;
import com.myrni.service.AdminDashboardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminDashboardController {

	private final AdminDashboardService dashboardService;

	@GetMapping("/dashboard")
	public ResponseEntity<AdminDashboardResponseVO> getDashboard() {

		return ResponseEntity.ok(dashboardService.getDashboard());
	}
}
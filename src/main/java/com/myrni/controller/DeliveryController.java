package com.myrni.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.myrni.requestVo.DeliveryAssignmentRequestVO;
import com.myrni.responsVO.DeliveryAssignmentResponseVO;
import com.myrni.service.DeliveryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/delivery")
@RequiredArgsConstructor
public class DeliveryController {

	private final DeliveryService deliveryService;

	@PostMapping("/assign")
	public ResponseEntity<DeliveryAssignmentResponseVO> assignOrder(
			@RequestBody DeliveryAssignmentRequestVO requestVO) {

		return ResponseEntity.ok(deliveryService.assignOrder(requestVO));
	}

	@GetMapping("/track/{orderId}")
	public ResponseEntity<DeliveryAssignmentResponseVO> trackOrder(@PathVariable Long orderId) {

		return ResponseEntity.ok(deliveryService.trackOrder(orderId));
	}
}
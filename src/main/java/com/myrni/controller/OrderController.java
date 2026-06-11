package com.myrni.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myrni.requestVo.PlaceOrderRequestVO;
import com.myrni.responsVO.OrderResponseVO;
import com.myrni.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	@PostMapping("/place")
	public ResponseEntity<OrderResponseVO> placeOrder(@RequestBody PlaceOrderRequestVO requestVO) {

		return ResponseEntity.ok(orderService.placeOrder(requestVO));
	}

	@GetMapping("/history/{userId}")
	public ResponseEntity<List<OrderResponseVO>> getHistory(@PathVariable Long userId) {
		return ResponseEntity.ok(orderService.getOrderHistory(userId));
	}

	@GetMapping("/{orderId}")
	public ResponseEntity<OrderResponseVO> getOrder(@PathVariable Long orderId) {

		return ResponseEntity.ok(orderService.getOrderById(orderId));
	}

	@PutMapping("/cancel/{orderId}")
	public ResponseEntity<OrderResponseVO> cancelOrder(@PathVariable Long orderId) {

		return ResponseEntity.ok(orderService.cancelOrder(orderId));
	}
}

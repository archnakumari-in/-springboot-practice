package com.myrni.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myrni.requestVo.AddToCartRequestVO;
import com.myrni.responsVO.CartResponseVO;
import com.myrni.service.CartService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

	private final CartService cartService;

	@PostMapping("/add")
	public ResponseEntity<CartResponseVO> addToCart(@RequestBody AddToCartRequestVO requestVO) {

		return ResponseEntity.ok(cartService.addToCart(requestVO));
	}

	@GetMapping("/{userId}")
	public ResponseEntity<CartResponseVO> getCart(@PathVariable Long userId) {

		return ResponseEntity.ok(cartService.getCart(userId));
	}

	@DeleteMapping("/item/{cartItemId}")
	public ResponseEntity<String> removeItem(@PathVariable Long cartItemId) {

		cartService.removeItem(cartItemId);

		return ResponseEntity.ok("Item removed successfully");
	}

}

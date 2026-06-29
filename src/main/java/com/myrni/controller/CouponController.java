package com.myrni.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.myrni.requestVo.ApplyCouponRequestVO;
import com.myrni.responsVO.CouponResponseVO;
import com.myrni.service.CouponService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/coupons")
@RequiredArgsConstructor
public class CouponController {

	private final CouponService couponService;

	@PostMapping("/apply")
	public ResponseEntity<CouponResponseVO> applyCoupon(@RequestBody ApplyCouponRequestVO requestVO) {

		return ResponseEntity.ok(couponService.applyCoupon(requestVO));
	}
}
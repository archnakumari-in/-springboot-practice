package com.myrni.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myrni.requestVo.ReviewRequestVO;
import com.myrni.responsVO.ReviewResponseVO;
import com.myrni.service.ReviewService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

	private final ReviewService reviewService;

	@PostMapping
	public ResponseEntity<ReviewResponseVO> addReview(@RequestBody ReviewRequestVO requestVO) {

		return ResponseEntity.ok(reviewService.addReview(requestVO));
	}

	@GetMapping("/restaurant/{restaurantId}")
	public ResponseEntity<List<ReviewResponseVO>> getReviews(@PathVariable Long restaurantId) {

		return ResponseEntity.ok(reviewService.getReviewsByRestaurant(restaurantId));
	}

}

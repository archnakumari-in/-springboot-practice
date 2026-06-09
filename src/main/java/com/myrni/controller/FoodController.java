package com.myrni.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myrni.requestVo.FoodRequestVO;
import com.myrni.responsVO.FoodResponseVO;
import com.myrni.service.FoodService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/foods")
@RequiredArgsConstructor
public class FoodController {

	private final FoodService foodService;

	@PostMapping
	public ResponseEntity<FoodResponseVO> addFood(@RequestBody FoodRequestVO requestVO) {

		return new ResponseEntity<>(foodService.addFood(requestVO), HttpStatus.CREATED);
	}

	@GetMapping("/{foodId}")
	public ResponseEntity<FoodResponseVO> getFoodById(@PathVariable Long foodId) {

		return ResponseEntity.ok(foodService.getFoodById(foodId));
	}

	@GetMapping
	public ResponseEntity<List<FoodResponseVO>> getAllFoods() {

		return ResponseEntity.ok(foodService.getAllFoods());
	}

	@GetMapping("/restaurant/{restaurantId}")
	public ResponseEntity<List<FoodResponseVO>> getFoodsByRestaurant(@PathVariable Long restaurantId) {

		return ResponseEntity.ok(foodService.getFoodsByRestaurant(restaurantId));
	}

	@DeleteMapping("/{foodId}")
	public ResponseEntity<String> deleteFood(@PathVariable Long foodId) {

		foodService.deleteFood(foodId);

		return ResponseEntity.ok("Food deleted successfully");
	}

}

package com.myrni.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myrni.requestVo.RestaurantRequestVO;
import com.myrni.responsVO.RestaurantResponseVO;
import com.myrni.service.RestaurantService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

	private final RestaurantService restaurantService;

	@PostMapping
	public ResponseEntity<RestaurantResponseVO> addRestaurant(@RequestBody RestaurantRequestVO requestVO) {

		return new ResponseEntity<>(restaurantService.addRestaurant(requestVO), HttpStatus.CREATED);
	}

	@GetMapping("/{restaurantId}")
	public ResponseEntity<RestaurantResponseVO> getRestaurantById(@PathVariable Long restaurantId) {

		return ResponseEntity.ok(restaurantService.getRestaurantById(restaurantId));
	}

	@GetMapping
	public ResponseEntity<List<RestaurantResponseVO>> getAllRestaurants() {

		return ResponseEntity.ok(restaurantService.getAllRestaurants());
	}

	@PutMapping("/{restaurantId}")
	public ResponseEntity<RestaurantResponseVO> updateRestaurant(@PathVariable Long restaurantId,
			@RequestBody RestaurantRequestVO requestVO) {

		return ResponseEntity.ok(restaurantService.updateRestaurant(restaurantId, requestVO));
	}

	@DeleteMapping("/{restaurantId}")
	public ResponseEntity<String> deleteRestaurant(@PathVariable Long restaurantId) {

		restaurantService.deleteRestaurant(restaurantId);

		return ResponseEntity.ok("Restaurant deleted successfully");
	}
}

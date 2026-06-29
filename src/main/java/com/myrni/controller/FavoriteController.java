package com.myrni.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.myrni.requestVo.FavoriteRequestVO;
import com.myrni.responsVO.FavoriteResponseVO;
import com.myrni.service.FavoriteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/favorites")
@RequiredArgsConstructor
public class FavoriteController {

	private final FavoriteService favoriteService;

	@PostMapping
	public ResponseEntity<FavoriteResponseVO> addFavorite(@RequestBody FavoriteRequestVO requestVO) {

		return ResponseEntity.ok(favoriteService.addFavorite(requestVO));
	}

	@GetMapping("/{userId}")
	public ResponseEntity<List<FavoriteResponseVO>> getFavorites(@PathVariable Long userId) {

		return ResponseEntity.ok(favoriteService.getFavorites(userId));
	}

	@DeleteMapping("/{userId}/{restaurantId}")
	public ResponseEntity<String> removeFavorite(@PathVariable Long userId, @PathVariable Long restaurantId) {

		favoriteService.removeFavorite(userId, restaurantId);

		return ResponseEntity.ok("Favorite removed successfully");
	}
}
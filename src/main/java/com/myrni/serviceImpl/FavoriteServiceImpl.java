package com.myrni.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.myrni.entity.*;
import com.myrni.repository.*;
import com.myrni.requestVo.FavoriteRequestVO;
import com.myrni.responsVO.FavoriteResponseVO;
import com.myrni.service.FavoriteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {

	private final FavoriteRepository favoriteRepository;

	private final UserRepository userRepository;

	private final RestaurantRepository restaurantRepository;

	@Override
	public FavoriteResponseVO addFavorite(FavoriteRequestVO requestVO) {

		UserEO user = userRepository.findById(requestVO.getUserId())
				.orElseThrow(() -> new RuntimeException("User not found"));

		RestaurantEO restaurant = restaurantRepository.findById(requestVO.getRestaurantId())
				.orElseThrow(() -> new RuntimeException("Restaurant not found"));

		if (favoriteRepository.findByUserUserIdAndRestaurantRestaurantId(user.getUserId(), restaurant.getRestaurantId())
				.isPresent()) {

			throw new RuntimeException("Already added to favorites");
		}

		FavoriteEO favorite = new FavoriteEO();

		favorite.setUser(user);
		favorite.setRestaurant(restaurant);

		favorite = favoriteRepository.save(favorite);

		return convertToResponse(favorite);
	}

	@Override
	public List<FavoriteResponseVO> getFavorites(Long userId) {

		return favoriteRepository.findByUserUserId(userId).stream().map(this::convertToResponse)
				.collect(Collectors.toList());
	}

	@Override
	public void removeFavorite(Long userId, Long restaurantId) {

		FavoriteEO favorite = favoriteRepository.findByUserUserIdAndRestaurantRestaurantId(userId, restaurantId)
				.orElseThrow(() -> new RuntimeException("Favorite not found"));

		favoriteRepository.delete(favorite);
	}

	private FavoriteResponseVO convertToResponse(FavoriteEO favorite) {

		FavoriteResponseVO response = new FavoriteResponseVO();

		response.setFavoriteId(favorite.getFavoriteId());

		response.setRestaurantId(favorite.getRestaurant().getRestaurantId());

		response.setRestaurantName(favorite.getRestaurant().getRestaurantName());

		response.setRestaurantAddress(favorite.getRestaurant().getAddress());

		return response;
	}
}
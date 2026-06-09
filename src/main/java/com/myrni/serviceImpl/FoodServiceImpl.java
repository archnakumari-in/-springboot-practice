package com.myrni.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.myrni.entity.FoodEO;
import com.myrni.entity.RestaurantEO;
import com.myrni.repository.FoodRepository;
import com.myrni.repository.RestaurantRepository;
import com.myrni.requestVo.FoodRequestVO;
import com.myrni.responsVO.FoodResponseVO;
import com.myrni.service.FoodService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {
	private final FoodRepository foodRepository;

	private final RestaurantRepository restaurantRepository;

	@Override
	public FoodResponseVO addFood(FoodRequestVO requestVO) {

		RestaurantEO restaurant = restaurantRepository.findById(requestVO.getRestaurantId())
				.orElseThrow(() -> new RuntimeException("Restaurant not found"));

		FoodEO food = new FoodEO();

		food.setFoodName(requestVO.getFoodName());
		food.setDescription(requestVO.getDescription());
		food.setPrice(requestVO.getPrice());
		food.setCategory(requestVO.getCategory());
		food.setFoodType(requestVO.getFoodType());
		food.setImageUrl(requestVO.getImageUrl());

		food.setAvailable(true);
		food.setRestaurant(restaurant);

		food = foodRepository.save(food);

		return convertToResponse(food);
	}

	@Override
	public FoodResponseVO getFoodById(Long foodId) {

		FoodEO food = foodRepository.findById(foodId).orElseThrow(() -> new RuntimeException("Food not found"));

		return convertToResponse(food);
	}

	@Override
	public List<FoodResponseVO> getAllFoods() {

		return foodRepository.findAll().stream().map(this::convertToResponse).collect(Collectors.toList());
	}

	@Override
	public List<FoodResponseVO> getFoodsByRestaurant(Long restaurantId) {

		return foodRepository.findByRestaurantRestaurantId(restaurantId).stream().map(this::convertToResponse)
				.collect(Collectors.toList());
	}

	@Override
	public void deleteFood(Long foodId) {

		foodRepository.deleteById(foodId);
	}

	private FoodResponseVO convertToResponse(FoodEO food) {

		FoodResponseVO response = new FoodResponseVO();

		response.setFoodId(food.getFoodId());
		response.setFoodName(food.getFoodName());
		response.setDescription(food.getDescription());
		response.setPrice(food.getPrice());
		response.setCategory(food.getCategory());
		response.setFoodType(food.getFoodType());
		response.setImageUrl(food.getImageUrl());
		response.setAvailable(food.getAvailable());

		response.setRestaurantId(food.getRestaurant().getRestaurantId());

		response.setRestaurantName(food.getRestaurant().getRestaurantName());

		return response;
	}

}

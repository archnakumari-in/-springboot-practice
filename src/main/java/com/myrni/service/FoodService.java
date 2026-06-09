package com.myrni.service;

import java.util.List;

import com.myrni.requestVo.FoodRequestVO;
import com.myrni.responsVO.FoodResponseVO;

public interface FoodService {

	FoodResponseVO addFood(FoodRequestVO requestVO);

	FoodResponseVO getFoodById(Long foodId);

	List<FoodResponseVO> getAllFoods();

	List<FoodResponseVO> getFoodsByRestaurant(Long restaurantId);

	void deleteFood(Long foodId);

}

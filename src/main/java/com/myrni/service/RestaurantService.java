package com.myrni.service;

import java.util.List;

import com.myrni.requestVo.RestaurantRequestVO;
import com.myrni.responsVO.RestaurantResponseVO;

public interface RestaurantService {
	
	 RestaurantResponseVO addRestaurant(
	            RestaurantRequestVO requestVO);

	    RestaurantResponseVO getRestaurantById(
	            Long restaurantId);

	    List<RestaurantResponseVO> getAllRestaurants();

	    RestaurantResponseVO updateRestaurant(
	            Long restaurantId,
	            RestaurantRequestVO requestVO);

	    void deleteRestaurant(Long restaurantId);

}

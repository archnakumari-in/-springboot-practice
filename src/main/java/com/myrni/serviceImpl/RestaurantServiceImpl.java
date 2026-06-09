package com.myrni.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.myrni.entity.RestaurantEO;
import com.myrni.repository.RestaurantRepository;
import com.myrni.requestVo.RestaurantRequestVO;
import com.myrni.responsVO.RestaurantResponseVO;
import com.myrni.service.RestaurantService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

	private final RestaurantRepository restaurantRepository;

	@Override
	public RestaurantResponseVO addRestaurant(RestaurantRequestVO requestVO) {

		RestaurantEO restaurant = new RestaurantEO();

		restaurant.setRestaurantName(requestVO.getRestaurantName());
		restaurant.setOwnerName(requestVO.getOwnerName());
		restaurant.setMobileNo(requestVO.getMobileNo());
		restaurant.setEmail(requestVO.getEmail());
		restaurant.setAddress(requestVO.getAddress());
		restaurant.setCity(requestVO.getCity());

		restaurant.setRating(0.0);
		restaurant.setActive(true);

		restaurant = restaurantRepository.save(restaurant);

		return convertToResponse(restaurant);
	}

	@Override
	public RestaurantResponseVO getRestaurantById(Long restaurantId) {

		RestaurantEO restaurant = restaurantRepository.findById(restaurantId)
				.orElseThrow(() -> new RuntimeException("Restaurant not found"));

		return convertToResponse(restaurant);
	}

	@Override
	public List<RestaurantResponseVO> getAllRestaurants() {

		return restaurantRepository.findAll().stream().map(this::convertToResponse).collect(Collectors.toList());
	}

	@Override
	public RestaurantResponseVO updateRestaurant(Long restaurantId, RestaurantRequestVO requestVO) {

		RestaurantEO restaurant = restaurantRepository.findById(restaurantId)
				.orElseThrow(() -> new RuntimeException("Restaurant not found"));

		restaurant.setRestaurantName(requestVO.getRestaurantName());
		restaurant.setOwnerName(requestVO.getOwnerName());
		restaurant.setMobileNo(requestVO.getMobileNo());
		restaurant.setEmail(requestVO.getEmail());
		restaurant.setAddress(requestVO.getAddress());
		restaurant.setCity(requestVO.getCity());

		restaurant = restaurantRepository.save(restaurant);

		return convertToResponse(restaurant);
	}

	@Override
	public void deleteRestaurant(Long restaurantId) {

		restaurantRepository.deleteById(restaurantId);
	}

	private RestaurantResponseVO convertToResponse(RestaurantEO restaurant) {

		RestaurantResponseVO response = new RestaurantResponseVO();

		response.setRestaurantId(restaurant.getRestaurantId());
		response.setRestaurantName(restaurant.getRestaurantName());
		response.setOwnerName(restaurant.getOwnerName());
		response.setMobileNo(restaurant.getMobileNo());
		response.setEmail(restaurant.getEmail());
		response.setAddress(restaurant.getAddress());
		response.setCity(restaurant.getCity());
		response.setRating(restaurant.getRating());
		response.setActive(restaurant.getActive());

		return response;
	}

}

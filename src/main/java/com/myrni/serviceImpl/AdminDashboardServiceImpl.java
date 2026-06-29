package com.myrni.serviceImpl;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.myrni.entity.RestaurantEO;
import com.myrni.repository.OrderRepository;
import com.myrni.repository.RestaurantRepository;
import com.myrni.repository.UserRepository;
import com.myrni.responsVO.AdminDashboardResponseVO;
import com.myrni.responsVO.TopRestaurantVO;
import com.myrni.service.AdminDashboardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminDashboardServiceImpl implements AdminDashboardService {

	private final UserRepository userRepository;

	private final RestaurantRepository restaurantRepository;

	private final OrderRepository orderRepository;

	@Override
	public AdminDashboardResponseVO getDashboard() {

		AdminDashboardResponseVO response = new AdminDashboardResponseVO();

		response.setTotalUsers(userRepository.count());

		response.setTotalRestaurants(restaurantRepository.count());

		response.setTotalOrders(orderRepository.count());

		response.setTotalRevenue(orderRepository.getTotalRevenue());

		response.setTopRestaurants(restaurantRepository.findTop5ByOrderByRatingDesc().stream()
				.map(this::convertToTopRestaurant).collect(Collectors.toList()));

		return response;
	}

	private TopRestaurantVO convertToTopRestaurant(RestaurantEO restaurant) {

		return new TopRestaurantVO(restaurant.getRestaurantId(), restaurant.getRestaurantName(),
				restaurant.getRating());
	}
}
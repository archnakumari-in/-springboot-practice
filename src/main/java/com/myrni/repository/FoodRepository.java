package com.myrni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myrni.entity.FoodEO;

public interface FoodRepository extends JpaRepository<FoodEO, Long> {
	
	 List<FoodEO> findByRestaurantRestaurantId(
	            Long restaurantId);

}

package com.myrni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myrni.entity.ReviewEO;

public interface ReviewRepository extends JpaRepository<ReviewEO, Long> {

	List<ReviewEO> findByRestaurantRestaurantId(Long restaurantId);
}
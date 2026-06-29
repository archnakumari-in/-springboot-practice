package com.myrni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myrni.entity.RestaurantEO;

public interface RestaurantRepository extends JpaRepository<RestaurantEO, Long> {
	List<RestaurantEO> findTop5ByOrderByRatingDesc();

}

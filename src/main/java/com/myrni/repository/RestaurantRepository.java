package com.myrni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myrni.entity.RestaurantEO;

public interface RestaurantRepository extends JpaRepository<RestaurantEO, Long> {

}

package com.myrni.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myrni.entity.FavoriteEO;

public interface FavoriteRepository
        extends JpaRepository<FavoriteEO, Long> {

    List<FavoriteEO> findByUserUserId(Long userId);

    Optional<FavoriteEO>
        findByUserUserIdAndRestaurantRestaurantId(
                Long userId,
                Long restaurantId);
}
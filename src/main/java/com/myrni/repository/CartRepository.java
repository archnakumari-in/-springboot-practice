package com.myrni.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myrni.serviceImpl.CartEO;

public interface CartRepository extends JpaRepository<CartEO, Long> {

	Optional<CartEO> findByUserUserId(Long userId);

}

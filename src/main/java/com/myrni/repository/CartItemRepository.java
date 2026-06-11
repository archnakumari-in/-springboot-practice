package com.myrni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myrni.serviceImpl.CartItemEO;

public interface CartItemRepository extends JpaRepository<CartItemEO, Long> {

}

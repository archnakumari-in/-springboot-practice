package com.myrni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myrni.entity.OrderEO;

public interface OrderRepository extends  JpaRepository<OrderEO, Long> {

    List<OrderEO> findByUserUserId(Long userId); 

}

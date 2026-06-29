package com.myrni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myrni.entity.OrderEO;

public interface OrderRepository extends  JpaRepository<OrderEO, Long> {

    List<OrderEO> findByUserUserId(Long userId); 
    
    @Query("""
    	       SELECT COALESCE(SUM(o.totalAmount),0)
    	       FROM OrderEO o
    	       """)
    	Double getTotalRevenue();

}

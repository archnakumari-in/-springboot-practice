package com.myrni.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myrni.entity.PaymentEO;

public interface PaymentRepository extends JpaRepository<PaymentEO, Long> {
	Optional<PaymentEO> findByOrderOrderId(Long orderId);

}

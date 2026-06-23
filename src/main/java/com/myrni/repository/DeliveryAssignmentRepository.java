package com.myrni.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myrni.entity.DeliveryAssignmentEO;

public interface DeliveryAssignmentRepository
        extends JpaRepository<DeliveryAssignmentEO, Long> {

    Optional<DeliveryAssignmentEO>
        findByOrderOrderId(Long orderId);
}
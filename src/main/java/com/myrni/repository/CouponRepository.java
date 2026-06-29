package com.myrni.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myrni.entity.CouponEO;

public interface CouponRepository
        extends JpaRepository<CouponEO, Long> {

    Optional<CouponEO> findByCouponCode(
            String couponCode);
}
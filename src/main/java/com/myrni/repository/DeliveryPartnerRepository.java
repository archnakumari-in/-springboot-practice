package com.myrni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myrni.entity.DeliveryPartnerEO;

public interface DeliveryPartnerRepository
        extends JpaRepository<DeliveryPartnerEO, Long> {

}
package com.myrni.entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "coupon")
@Data
public class CouponEO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long couponId;

    @Column(unique = true)
    private String couponCode;

    private Double discountPercentage;

    private Double maxDiscountAmount;

    private Double minimumOrderAmount;

    private LocalDate expiryDate;

    private Boolean active;
}
package com.myrni.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "delivery_partner")
@Data
public class DeliveryPartnerEO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partnerId;

    private String fullName;

    private String mobileNo;

    private String email;

    private String vehicleNumber;

    private Boolean active;

    private Double rating;
}
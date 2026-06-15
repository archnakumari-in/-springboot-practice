package com.myrni.entity;


import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "reviews")
@Data
public class ReviewEO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEO user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private RestaurantEO restaurant;

    private Integer rating;

    private String reviewMessage;

    private LocalDateTime reviewDate;
}
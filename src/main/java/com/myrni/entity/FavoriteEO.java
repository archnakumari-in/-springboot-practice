package com.myrni.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "favorites")
@Data
public class FavoriteEO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favoriteId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEO user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private RestaurantEO restaurant;
}
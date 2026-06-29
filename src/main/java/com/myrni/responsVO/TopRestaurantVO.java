package com.myrni.responsVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopRestaurantVO {

    private Long restaurantId;

    private String restaurantName;

    private Double rating;
} 	
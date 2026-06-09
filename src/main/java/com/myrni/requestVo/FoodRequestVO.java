package com.myrni.requestVo;

import lombok.Data;

@Data
public class FoodRequestVO {
	private String foodName;

	private String description;

	private Double price;

	private String category;

	private String foodType;

	private String imageUrl;

	private Long restaurantId;

}

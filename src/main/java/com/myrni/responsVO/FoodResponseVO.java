package com.myrni.responsVO;

import lombok.Data;

@Data
public class FoodResponseVO {
	private Long foodId;

	private String foodName;

	private String description;

	private Double price;

	private String category;

	private String foodType;

	private String imageUrl;

	private Boolean available;

	private Long restaurantId;

	private String restaurantName;

}

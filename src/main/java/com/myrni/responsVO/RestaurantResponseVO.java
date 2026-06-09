package com.myrni.responsVO;

import lombok.Data;

@Data
public class RestaurantResponseVO {

	private Long restaurantId;
	private String restaurantName;
	private String ownerName;
	private String mobileNo;
	private String email;
	private String address;
	private String city;
	private Double rating;
	private Boolean active;

}

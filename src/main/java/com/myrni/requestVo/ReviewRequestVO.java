package com.myrni.requestVo;

import lombok.Data;

@Data
public class ReviewRequestVO {
	
	private Long userId;

    private Long restaurantId;

    private Integer rating;

    private String reviewMessage;

}

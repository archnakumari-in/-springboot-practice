package com.myrni.responsVO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReviewResponseVO {
	
	private Long reviewId;

    private Long userId;

    private String userName;

    private Long restaurantId;

    private String restaurantName;

    private Integer rating;

    private String reviewMessage;

    private LocalDateTime reviewDate;

}

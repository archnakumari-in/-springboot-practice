package com.myrni.service;

import java.util.List;

import com.myrni.requestVo.ReviewRequestVO;
import com.myrni.responsVO.ReviewResponseVO;

public interface ReviewService {
	ReviewResponseVO addReview(ReviewRequestVO requestVO);

	List<ReviewResponseVO> getReviewsByRestaurant(Long restaurantId);

}

package com.myrni.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.myrni.entity.RestaurantEO;
import com.myrni.entity.ReviewEO;
import com.myrni.entity.UserEO;
import com.myrni.repository.RestaurantRepository;
import com.myrni.repository.ReviewRepository;
import com.myrni.repository.UserRepository;
import com.myrni.requestVo.ReviewRequestVO;
import com.myrni.responsVO.ReviewResponseVO;
import com.myrni.service.ReviewService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

	private final ReviewRepository reviewRepository;
	private final UserRepository userRepository;
	private final RestaurantRepository restaurantRepository;

	@Override
	public ReviewResponseVO addReview(ReviewRequestVO requestVO) {

		UserEO user = userRepository.findById(requestVO.getUserId())
				.orElseThrow(() -> new RuntimeException("User not found"));

		RestaurantEO restaurant = restaurantRepository.findById(requestVO.getRestaurantId())
				.orElseThrow(() -> new RuntimeException("Restaurant not found"));

		ReviewEO review = new ReviewEO();

		review.setUser(user);
		review.setRestaurant(restaurant);
		review.setRating(requestVO.getRating());
		review.setReviewMessage(requestVO.getReviewMessage());

		review.setReviewDate(LocalDateTime.now());

		review = reviewRepository.save(review);

		updateRestaurantRating(restaurant.getRestaurantId());

		return convertToResponse(review);
	}

	@Override
	public List<ReviewResponseVO> getReviewsByRestaurant(Long restaurantId) {

		return reviewRepository.findByRestaurantRestaurantId(restaurantId).stream().map(this::convertToResponse)
				.collect(Collectors.toList());
	}

	private void updateRestaurantRating(Long restaurantId) {

		List<ReviewEO> reviews = reviewRepository.findByRestaurantRestaurantId(restaurantId);

		double avgRating = reviews.stream().mapToInt(ReviewEO::getRating).average().orElse(0.0);

		RestaurantEO restaurant = restaurantRepository.findById(restaurantId).orElseThrow();

		restaurant.setRating(avgRating);

		restaurantRepository.save(restaurant);
	}

	private ReviewResponseVO convertToResponse(ReviewEO review) {

		ReviewResponseVO response = new ReviewResponseVO();

		response.setReviewId(review.getReviewId());

		response.setUserId(review.getUser().getUserId());

		response.setUserName(review.getUser().getFullName());

		response.setRestaurantId(review.getRestaurant().getRestaurantId());

		response.setRestaurantName(review.getRestaurant().getRestaurantName());

		response.setRating(review.getRating());

		response.setReviewMessage(review.getReviewMessage());

		response.setReviewDate(review.getReviewDate());

		return response;
	}

}

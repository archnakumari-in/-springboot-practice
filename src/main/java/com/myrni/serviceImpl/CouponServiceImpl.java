package com.myrni.serviceImpl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

//import com.myrni.entity.CartEO;
import com.myrni.entity.CouponEO;
import com.myrni.repository.CartRepository;
import com.myrni.repository.CouponRepository;
import com.myrni.requestVo.ApplyCouponRequestVO;
import com.myrni.responsVO.CouponResponseVO;
import com.myrni.service.CouponService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {

	private final CouponRepository couponRepository;

	private final CartRepository cartRepository;

	@Override
	public CouponResponseVO applyCoupon(ApplyCouponRequestVO requestVO) {

		CouponEO coupon = couponRepository.findByCouponCode(requestVO.getCouponCode())
				.orElseThrow(() -> new RuntimeException("Coupon not found"));

		CartEO cart = cartRepository.findByUserUserId(requestVO.getUserId())
				.orElseThrow(() -> new RuntimeException("Cart not found"));

		if (!coupon.getActive()) {
			throw new RuntimeException("Coupon inactive");
		}

		if (coupon.getExpiryDate().isBefore(LocalDate.now())) {

			throw new RuntimeException("Coupon expired");
		}

		if (cart.getTotalAmount() < coupon.getMinimumOrderAmount()) {

			throw new RuntimeException("Minimum order amount not met");
		}

		double discount = cart.getTotalAmount() * coupon.getDiscountPercentage() / 100;

		if (discount > coupon.getMaxDiscountAmount()) {

			discount = coupon.getMaxDiscountAmount();
		}

		double finalAmount = cart.getTotalAmount() - discount;

		CouponResponseVO response = new CouponResponseVO();

		response.setCouponCode(coupon.getCouponCode());

		response.setOriginalAmount(cart.getTotalAmount());

		response.setDiscountAmount(discount);

		response.setFinalAmount(finalAmount);

		response.setMessage("Coupon Applied Successfully");

		return response;
	}
}
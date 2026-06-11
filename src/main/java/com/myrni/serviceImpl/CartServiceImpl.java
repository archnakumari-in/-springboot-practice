package com.myrni.serviceImpl;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.myrni.entity.FoodEO;
import com.myrni.entity.UserEO;
import com.myrni.repository.CartItemRepository;
import com.myrni.repository.CartRepository;
import com.myrni.repository.FoodRepository;
import com.myrni.repository.UserRepository;
import com.myrni.requestVo.AddToCartRequestVO;
import com.myrni.responsVO.CartItemResponseVO;
import com.myrni.responsVO.CartResponseVO;
import com.myrni.service.CartService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

	private final CartRepository cartRepository;
	private final UserRepository userRepository;
	private final FoodRepository foodRepository;
	private final CartItemRepository cartItemRepository;

	@Override
	public CartResponseVO addToCart(AddToCartRequestVO requestVO) {

		UserEO user = userRepository.findById(requestVO.getUserId())
				.orElseThrow(() -> new RuntimeException("User not found"));

		FoodEO food = foodRepository.findById(requestVO.getFoodId())
				.orElseThrow(() -> new RuntimeException("Food not found"));

		CartEO cart = cartRepository.findByUserUserId(user.getUserId()).orElseGet(() -> {

			CartEO newCart = new CartEO();
			newCart.setUser(user);
			newCart.setTotalAmount(0.0);
			newCart.setCartItems(new ArrayList<>());

			return cartRepository.save(newCart);
		});

		CartItemEO item = new CartItemEO();

		item.setCart(cart);
		item.setFood(food);
		item.setQuantity(requestVO.getQuantity());

		item.setItemTotal(food.getPrice() * requestVO.getQuantity());

		cartItemRepository.save(item);

		cart.getCartItems().add(item);

		double total = cart.getCartItems().stream().mapToDouble(CartItemEO::getItemTotal).sum();

		cart.setTotalAmount(total);

		cartRepository.save(cart);

		return convertToResponse(cart);
	}

	@Override
	public CartResponseVO getCart(Long userId) {

		CartEO cart = cartRepository.findByUserUserId(userId).orElseThrow(() -> new RuntimeException("Cart not found"));

		return convertToResponse(cart);
	}

	@Override
	public void removeItem(Long cartItemId) {

		cartItemRepository.deleteById(cartItemId);
	}

	private CartResponseVO convertToResponse(CartEO cart) {

		CartResponseVO response = new CartResponseVO();

		response.setCartId(cart.getCartId());

		response.setUserId(cart.getUser().getUserId());

		response.setTotalAmount(cart.getTotalAmount());

		response.setItems(cart.getCartItems().stream().map(item -> {

			CartItemResponseVO vo = new CartItemResponseVO();

			vo.setCartItemId(item.getCartItemId());

			vo.setFoodId(item.getFood().getFoodId());

			vo.setFoodName(item.getFood().getFoodName());

			vo.setPrice(item.getFood().getPrice());

			vo.setQuantity(item.getQuantity());

			vo.setItemTotal(item.getItemTotal());

			return vo;
		}).collect(Collectors.toList()));

		return response;
	}

}

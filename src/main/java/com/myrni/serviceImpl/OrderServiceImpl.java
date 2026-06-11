package com.myrni.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.myrni.Enum.OrderStatus;
import com.myrni.entity.OrderEO;
import com.myrni.entity.OrderItemEO;
import com.myrni.entity.UserEO;
import com.myrni.repository.CartRepository;
import com.myrni.repository.OrderRepository;
import com.myrni.repository.UserRepository;
import com.myrni.requestVo.PlaceOrderRequestVO;
import com.myrni.responsVO.OrderItemResponseVO;
import com.myrni.responsVO.OrderResponseVO;
import com.myrni.service.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

	private final UserRepository userRepository;
	private final CartRepository cartRepository;
	private final OrderRepository orderRepository;

	@Override
	public OrderResponseVO placeOrder(PlaceOrderRequestVO requestVO) {

		UserEO user = userRepository.findById(requestVO.getUserId())
				.orElseThrow(() -> new RuntimeException("User not found"));

		CartEO cart = cartRepository.findByUserUserId(user.getUserId())
				.orElseThrow(() -> new RuntimeException("Cart not found"));

		OrderEO order = new OrderEO();

		order.setUser(user);
		order.setOrderDate(LocalDateTime.now());
		order.setOrderStatus(OrderStatus.PLACED);
		order.setTotalAmount(cart.getTotalAmount());

		List<OrderItemEO> orderItems = new ArrayList<>();

		for (CartItemEO cartItem : cart.getCartItems()) {

			OrderItemEO item = new OrderItemEO();

			item.setOrder(order);
			item.setFood(cartItem.getFood());
			item.setQuantity(cartItem.getQuantity());

			item.setPrice(cartItem.getFood().getPrice());

			item.setTotalPrice(cartItem.getItemTotal());

			orderItems.add(item);
		}

		order.setOrderItems(orderItems);

		order = orderRepository.save(order);
		// Clear Cart
		cart.getCartItems().clear();
		cart.setTotalAmount(0.0);
		cartRepository.save(cart);

		return convertToResponse(order);
	}

	@Override
	public List<OrderResponseVO> getOrderHistory(Long userId) {

		return orderRepository.findByUserUserId(userId).stream().map(this::convertToResponse)
				.collect(Collectors.toList());
	}

	@Override
	public OrderResponseVO getOrderById(Long orderId) {

		OrderEO order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));

		return convertToResponse(order);
	}

	@Override
	public OrderResponseVO cancelOrder(Long orderId) {

		OrderEO order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));

		order.setOrderStatus(OrderStatus.CANCELLED);

		orderRepository.save(order);

		return convertToResponse(order);
	}

	private OrderResponseVO convertToResponse(OrderEO order) {

		OrderResponseVO response = new OrderResponseVO();

		response.setOrderId(order.getOrderId());
		response.setUserId(order.getUser().getUserId());
		response.setTotalAmount(order.getTotalAmount());
		response.setOrderStatus(order.getOrderStatus().name());
		response.setOrderDate(order.getOrderDate());

		response.setItems(order.getOrderItems().stream().map(item -> {

			OrderItemResponseVO vo = new OrderItemResponseVO();

			vo.setFoodId(item.getFood().getFoodId());

			vo.setFoodName(item.getFood().getFoodName());

			vo.setQuantity(item.getQuantity());

			vo.setPrice(item.getPrice());

			vo.setTotalPrice(item.getTotalPrice());

			return vo;
		}).collect(Collectors.toList()));

		return response;
	}

}

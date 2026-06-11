package com.myrni.service;

import java.util.List;

import com.myrni.requestVo.PlaceOrderRequestVO;
import com.myrni.responsVO.OrderResponseVO;

public interface OrderService {
	OrderResponseVO placeOrder(PlaceOrderRequestVO requestVO);

	List<OrderResponseVO> getOrderHistory(Long userId);

	OrderResponseVO getOrderById(Long orderId);

	OrderResponseVO cancelOrder(Long orderId);

}

package com.myrni.responsVO;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
@Data
public class OrderResponseVO {
	
	private Long orderId;

    private Long userId;

    private Double totalAmount;

    private String orderStatus;

    private LocalDateTime orderDate;

    private List<OrderItemResponseVO> items;

}

package com.myrni.responsVO;

import java.util.List;

import lombok.Data;
@Data
public class CartResponseVO {
	 private Long cartId;

	    private Long userId;

	    private Double totalAmount;

	    private List<CartItemResponseVO> items;

}

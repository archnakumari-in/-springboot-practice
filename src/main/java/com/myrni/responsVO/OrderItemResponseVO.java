package com.myrni.responsVO;

import lombok.Data;

@Data
public class OrderItemResponseVO {
	
	 private Long foodId;

	    private String foodName;

	    private Integer quantity;

	    private Double price;

	    private Double totalPrice;

}

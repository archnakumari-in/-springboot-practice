package com.myrni.responsVO;

import lombok.Data;

@Data
public class CartItemResponseVO {
	
	 private Long cartItemId;

	    private Long foodId;

	    private String foodName;

	    private Double price;

	    private Integer quantity;

	    private Double itemTotal;

}

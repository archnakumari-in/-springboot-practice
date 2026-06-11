package com.myrni.requestVo;

import lombok.Data;

@Data
public class AddToCartRequestVO {

	private Long userId;

	private Long foodId;

	private Integer quantity;

}

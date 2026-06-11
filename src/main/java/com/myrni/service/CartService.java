package com.myrni.service;

import com.myrni.requestVo.AddToCartRequestVO;
import com.myrni.responsVO.CartResponseVO;

public interface CartService {

	CartResponseVO addToCart(AddToCartRequestVO requestVO);

	CartResponseVO getCart(Long userId);

	void removeItem(Long cartItemId);

}

package com.myrni.service;

import com.myrni.requestVo.ApplyCouponRequestVO;
import com.myrni.responsVO.CouponResponseVO;

public interface CouponService {

    CouponResponseVO applyCoupon(
            ApplyCouponRequestVO requestVO);
}
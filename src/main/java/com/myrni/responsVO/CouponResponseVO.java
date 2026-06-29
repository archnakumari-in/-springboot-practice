package com.myrni.responsVO;

import lombok.Data;

@Data
public class CouponResponseVO {

    private String couponCode;

    private Double originalAmount;

    private Double discountAmount;

    private Double finalAmount;

    private String message;
}
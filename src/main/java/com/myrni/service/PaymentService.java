package com.myrni.service;

import com.myrni.requestVo.PaymentRequestVO;
import com.myrni.responsVO.PaymentResponseVO;

public interface PaymentService {

	PaymentResponseVO makePayment(PaymentRequestVO requestVO);

	PaymentResponseVO getPaymentByOrder(Long orderId);

}

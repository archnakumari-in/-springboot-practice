package com.myrni.responsVO;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class PaymentResponseVO {
	
	private Long paymentId;

    private Long orderId;

    private Double amount;

    private String paymentMode;

    private String paymentStatus;

    private String transactionId;

    private LocalDateTime paymentDate;

}

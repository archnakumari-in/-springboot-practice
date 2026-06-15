package com.myrni.entity;

import java.time.LocalDateTime;

import com.myrni.Enum.PaymentMode;
import com.myrni.Enum.PaymentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "payments")
@Data
public class PaymentEO {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long paymentId;

	    @OneToOne
	    @JoinColumn(name = "order_id")
	    private OrderEO order;

	    private Double amount;

	    @Enumerated(EnumType.STRING)
	    private PaymentMode paymentMode;

	    @Enumerated(EnumType.STRING)
	    private PaymentStatus paymentStatus;

	    private String transactionId;

	    private LocalDateTime paymentDate;


}

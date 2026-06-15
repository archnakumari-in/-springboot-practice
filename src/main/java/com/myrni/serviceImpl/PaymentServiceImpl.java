package com.myrni.serviceImpl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.myrni.Enum.PaymentMode;
import com.myrni.Enum.PaymentStatus;
import com.myrni.entity.OrderEO;
import com.myrni.entity.PaymentEO;
import com.myrni.repository.OrderRepository;
import com.myrni.repository.PaymentRepository;
import com.myrni.requestVo.PaymentRequestVO;
import com.myrni.responsVO.PaymentResponseVO;
import com.myrni.service.PaymentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

	private final PaymentRepository paymentRepository;
	private final OrderRepository orderRepository;

	@Override
	public PaymentResponseVO makePayment(PaymentRequestVO requestVO) {

		OrderEO order = orderRepository.findById(requestVO.getOrderId())
				.orElseThrow(() -> new RuntimeException("Order not found"));

		PaymentEO payment = new PaymentEO();

		payment.setOrder(order);

		payment.setAmount(order.getTotalAmount());

		payment.setPaymentMode(PaymentMode.valueOf(requestVO.getPaymentMode()));

		payment.setPaymentStatus(PaymentStatus.SUCCESS);

		payment.setTransactionId(UUID.randomUUID().toString());

		payment.setPaymentDate(LocalDateTime.now());

		payment = paymentRepository.save(payment);

		return convertToResponse(payment);
	}

	@Override
	public PaymentResponseVO getPaymentByOrder(Long orderId) {

		PaymentEO payment = paymentRepository.findByOrderOrderId(orderId)
				.orElseThrow(() -> new RuntimeException("Payment not found"));

		return convertToResponse(payment);
	}

	private PaymentResponseVO convertToResponse(PaymentEO payment) {

		PaymentResponseVO response = new PaymentResponseVO();

		response.setPaymentId(payment.getPaymentId());

		response.setOrderId(payment.getOrder().getOrderId());

		response.setAmount(payment.getAmount());

		response.setPaymentMode(payment.getPaymentMode().name());

		response.setPaymentStatus(payment.getPaymentStatus().name());

		response.setTransactionId(payment.getTransactionId());

		response.setPaymentDate(payment.getPaymentDate());

		return response;
	}

}

package com.myrni.serviceImpl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.myrni.Enum.DeliveryStatus;
import com.myrni.entity.*;
import com.myrni.repository.*;
import com.myrni.requestVo.DeliveryAssignmentRequestVO;
import com.myrni.responsVO.DeliveryAssignmentResponseVO;
import com.myrni.service.DeliveryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

	private final OrderRepository orderRepository;

	private final DeliveryPartnerRepository deliveryPartnerRepository;

	private final DeliveryAssignmentRepository deliveryAssignmentRepository;

	@Override
	public DeliveryAssignmentResponseVO assignOrder(DeliveryAssignmentRequestVO requestVO) {

		OrderEO order = orderRepository.findById(requestVO.getOrderId())
				.orElseThrow(() -> new RuntimeException("Order not found"));

		DeliveryPartnerEO partner = deliveryPartnerRepository.findById(requestVO.getPartnerId())
				.orElseThrow(() -> new RuntimeException("Partner not found"));

		DeliveryAssignmentEO assignment = new DeliveryAssignmentEO();

		assignment.setOrder(order);
		assignment.setPartner(partner);
		assignment.setAssignedTime(LocalDateTime.now());

		assignment.setDeliveryStatus(DeliveryStatus.ASSIGNED);

		assignment = deliveryAssignmentRepository.save(assignment);

		return convertToResponse(assignment);
	}

	@Override
	public DeliveryAssignmentResponseVO trackOrder(Long orderId) {

		DeliveryAssignmentEO assignment = deliveryAssignmentRepository.findByOrderOrderId(orderId)
				.orElseThrow(() -> new RuntimeException("Assignment not found"));

		return convertToResponse(assignment);
	}

	private DeliveryAssignmentResponseVO convertToResponse(DeliveryAssignmentEO assignment) {

		DeliveryAssignmentResponseVO response = new DeliveryAssignmentResponseVO();

		response.setAssignmentId(assignment.getAssignmentId());

		response.setOrderId(assignment.getOrder().getOrderId());

		response.setPartnerId(assignment.getPartner().getPartnerId());

		response.setPartnerName(assignment.getPartner().getFullName());

		response.setDeliveryStatus(assignment.getDeliveryStatus().name());

		return response;
	}
}
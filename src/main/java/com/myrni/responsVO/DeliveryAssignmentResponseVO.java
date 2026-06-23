package com.myrni.responsVO;

import lombok.Data;

@Data
public class DeliveryAssignmentResponseVO {

    private Long assignmentId;

    private Long orderId;

    private Long partnerId;

    private String partnerName;

    private String deliveryStatus;
}
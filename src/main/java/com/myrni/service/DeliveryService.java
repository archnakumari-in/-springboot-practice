package com.myrni.service;

import com.myrni.requestVo.DeliveryAssignmentRequestVO;
import com.myrni.responsVO.DeliveryAssignmentResponseVO;

public interface DeliveryService {

    DeliveryAssignmentResponseVO assignOrder(
            DeliveryAssignmentRequestVO requestVO);

    DeliveryAssignmentResponseVO trackOrder(
            Long orderId);
}
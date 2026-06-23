package com.myrni.entity;

import java.time.LocalDateTime;

import com.myrni.Enum.DeliveryStatus;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "delivery_assignment")
@Data
public class DeliveryAssignmentEO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignmentId;

    @OneToOne
    @JoinColumn(name = "order_id")
    private OrderEO order;

    @ManyToOne
    @JoinColumn(name = "partner_id")
    private DeliveryPartnerEO partner;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    private LocalDateTime assignedTime;

    private LocalDateTime deliveredTime;
}
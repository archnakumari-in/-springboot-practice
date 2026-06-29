package com.myrni.responsVO;

import java.util.List;

import lombok.Data;

@Data
public class AdminDashboardResponseVO {

    private Long totalUsers;

    private Long totalRestaurants;

    private Long totalOrders;

    private Double totalRevenue;

    private List<TopRestaurantVO> topRestaurants;
}
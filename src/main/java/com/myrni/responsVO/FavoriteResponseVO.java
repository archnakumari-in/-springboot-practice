package com.myrni.responsVO;

import lombok.Data;

@Data
public class FavoriteResponseVO {

    private Long favoriteId;

    private Long restaurantId;

    private String restaurantName;

    private String restaurantAddress;
}
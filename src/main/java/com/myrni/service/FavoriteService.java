package com.myrni.service;

import java.util.List;

import com.myrni.requestVo.FavoriteRequestVO;
import com.myrni.responsVO.FavoriteResponseVO;

public interface FavoriteService {

    FavoriteResponseVO addFavorite(
            FavoriteRequestVO requestVO);

    List<FavoriteResponseVO> getFavorites(
            Long userId);

    void removeFavorite(
            Long userId,
            Long restaurantId);
}
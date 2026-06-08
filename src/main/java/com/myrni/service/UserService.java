package com.myrni.service;

import java.util.List;

import com.myrni.requestVo.UserRequestVO;
import com.myrni.responsVO.UserResponseVO;

public interface UserService {
	
	UserResponseVO registerUser(UserRequestVO requestVO);

    UserResponseVO getUserById(Long userId);

    List<UserResponseVO> getAllUsers();

}

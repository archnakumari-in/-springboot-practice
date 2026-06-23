package com.myrni.service;

import com.myrni.requestVo.LoginRequestVO;
import com.myrni.responsVO.LoginResponseVO;

public interface AuthService {

	LoginResponseVO login(LoginRequestVO requestVO);

}

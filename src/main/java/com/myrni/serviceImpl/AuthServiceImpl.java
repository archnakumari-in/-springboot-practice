package com.myrni.serviceImpl;

import org.springframework.stereotype.Service;

import com.myrni.entity.UserEO;
import com.myrni.repository.UserRepository;
import com.myrni.requestVo.LoginRequestVO;
import com.myrni.responsVO.LoginResponseVO;
import com.myrni.security.JwtUtil;
import com.myrni.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

	private final UserRepository userRepository;

	@Override
	public LoginResponseVO login(LoginRequestVO requestVO) {

		UserEO user = userRepository.findByEmail(requestVO.getEmail())
				.orElseThrow(() -> new RuntimeException("Invalid email"));

		if (!user.getPassword().equals(requestVO.getPassword())) {

			throw new RuntimeException("Invalid password");
		}

		String token = JwtUtil.generateToken(user.getEmail());

		return LoginResponseVO.builder().token(token).email(user.getEmail()).role(user.getRole().name()).build();
	}

}

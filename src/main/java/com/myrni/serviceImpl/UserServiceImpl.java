package com.myrni.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.myrni.entity.UserEO;
import com.myrni.repository.UserRepository;
import com.myrni.requestVo.UserRequestVO;
import com.myrni.responsVO.UserResponseVO;
import com.myrni.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	public UserResponseVO registerUser(UserRequestVO requestVO) {

		if (userRepository.existsByEmail(requestVO.getEmail())) {
			throw new RuntimeException("Email already exists");
		}

		if (userRepository.existsByMobileNo(requestVO.getMobileNo())) {
			throw new RuntimeException("Mobile number already exists");
		}

		UserEO userEO = new UserEO();

		userEO.setFullName(requestVO.getFullName());
		userEO.setEmail(requestVO.getEmail());
		userEO.setMobileNo(requestVO.getMobileNo());
		userEO.setPassword(requestVO.getPassword());
		userEO.setAddress(requestVO.getAddress());
		userEO.setRole("CUSTOMER");

		userEO = userRepository.save(userEO);

		return convertToResponse(userEO);
	}

	@Override
	public UserResponseVO getUserById(Long userId) {

		UserEO userEO = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

		return convertToResponse(userEO);
	}

	@Override
	public List<UserResponseVO> getAllUsers() {

		return userRepository.findAll().stream().map(this::convertToResponse).collect(Collectors.toList());
	}

	private UserResponseVO convertToResponse(UserEO userEO) {

		UserResponseVO responseVO = new UserResponseVO();

		responseVO.setUserId(userEO.getUserId());
		responseVO.setFullName(userEO.getFullName());
		responseVO.setEmail(userEO.getEmail());
		responseVO.setMobileNo(userEO.getMobileNo());
		responseVO.setAddress(userEO.getAddress());
		responseVO.setRole(userEO.getRole());

		return responseVO;
	}

}

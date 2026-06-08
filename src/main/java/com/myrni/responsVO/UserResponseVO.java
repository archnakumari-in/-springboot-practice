package com.myrni.responsVO;

import lombok.Data;

@Data
public class UserResponseVO {
	private Long userId;
	private String fullName;
	private String email;
	private String mobileNo;
	private String address;
	private String role;

}

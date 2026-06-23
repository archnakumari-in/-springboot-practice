package com.myrni.responsVO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseVO {
	private String token;
    private String email;
    private String role;

}

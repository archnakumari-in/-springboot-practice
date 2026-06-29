package com.myrni.requestVo;

import lombok.Data;

@Data
public class EmailRequestVO {

    private String toEmail;

    private String subject;

    private String message;
}
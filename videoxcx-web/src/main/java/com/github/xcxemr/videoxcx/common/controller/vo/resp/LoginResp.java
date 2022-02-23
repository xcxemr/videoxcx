package com.github.xcxemr.videoxcx.common.controller.vo.resp;

import lombok.Data;

@Data
public class LoginResp {
    private String openId;
    private String token;
    private Integer onlineVersion;
}

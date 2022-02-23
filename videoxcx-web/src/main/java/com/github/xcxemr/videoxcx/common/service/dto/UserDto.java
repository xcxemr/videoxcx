package com.github.xcxemr.videoxcx.common.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String openId;
    private String token;
    private Integer onlineVersion;
}

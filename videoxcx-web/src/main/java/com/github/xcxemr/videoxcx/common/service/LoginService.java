package com.github.xcxemr.videoxcx.common.service;

import com.github.xcxemr.videoxcx.common.service.dto.UserDto;

public interface LoginService {
    UserDto login(String wxCode);
}

package com.github.xcxemr.videoxcx.common.controller;

import cn.hutool.core.bean.BeanUtil;
import com.github.xcxemr.videoxcx.common.result.ObjectResult;
import com.github.xcxemr.videoxcx.common.service.LoginService;
import com.github.xcxemr.videoxcx.common.service.dto.UserDto;
import com.github.xcxemr.videoxcx.common.controller.vo.req.LoginReq;
import com.github.xcxemr.videoxcx.common.controller.vo.resp.LoginResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class WXLoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("loginwx")
    public ObjectResult<LoginResp> index(@RequestBody LoginReq loginReq) {
        UserDto login = loginService.login(loginReq.getCode());
        return ObjectResult.success(BeanUtil.copyProperties(login, LoginResp.class));
    }
}

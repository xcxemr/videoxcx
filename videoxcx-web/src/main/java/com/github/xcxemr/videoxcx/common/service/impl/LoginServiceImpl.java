package com.github.xcxemr.videoxcx.common.service.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.jwt.JWTUtil;
import com.github.xcxemr.videoxcx.common.service.LoginService;
import com.github.xcxemr.videoxcx.common.service.VersionService;
import com.github.xcxemr.videoxcx.common.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Value("${wx.appid}")
    private String appid;

    @Value("${wx.sec}")
    private String sec;

    @Value("${jwt.key}")
    private String jwtKey;

    @Autowired
    private VersionService versionService;

    @Override
    public UserDto login(String wxCode) {

        String body = HttpRequest.get(String.format("https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code", appid, sec, wxCode))
                .execute().body();
        JSONObject jsonObject = JSONUtil.parseObj(body);
        String openId = jsonObject.getStr("openid");


        byte[] key = jwtKey.getBytes();

        Map<String, Object> map = new HashMap<String, Object>() {
            private static final long serialVersionUID = 1L;

            {
                put("openId", openId);
                put("expire_time", System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 15);
            }
        };

        String token = JWTUtil.createToken(map, key);
        return new UserDto(openId, token, versionService.onlineVersion());
    }
}

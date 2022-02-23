package com.github.xcxemr.videoxcx.interceptor;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.github.xcxemr.videoxcx.exception.SignErrorException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Value("${jwt.key}")
    private String jwtKey;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String authorization = request.getHeader("Authorization");
        if (StringUtils.isNotEmpty(authorization)) {
            String auth = authorization.replace("Bearer", "").trim();
            JWT jwt = JWTUtil.parseToken(auth);
            boolean verify = JWTUtil.verify(auth, jwtKey.getBytes());
            if (!verify){
                throw new SignErrorException();
            }
            return true;
        }
        throw new SignErrorException();

    }
}

package com.github.xcxemr.videoxcx.common.service.impl;

import com.github.xcxemr.videoxcx.common.service.VersionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class VersionServiceImpl implements VersionService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public int onlineVersion() {
        String onlineVersion = stringRedisTemplate.opsForValue().get("online_version");
        if (StringUtils.isNotBlank(onlineVersion)){
            return Integer.parseInt(onlineVersion);
        }
        return 1;
    }
}

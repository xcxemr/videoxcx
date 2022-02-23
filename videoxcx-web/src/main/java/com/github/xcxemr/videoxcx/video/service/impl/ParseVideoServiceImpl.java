package com.github.xcxemr.videoxcx.video.service.impl;

import cn.hutool.extra.spring.SpringUtil;
import com.github.xcxemr.videoxcx.video.anno.ParseVideoServiceAnno;
import com.github.xcxemr.videoxcx.video.service.ParseVideoService;
import com.github.xcxemr.videoxcx.video.service.parse.IVideoParse;
import lombok.extern.slf4j.Slf4j;
import com.github.xcxemr.videoxcx.video.service.dto.VideoInfoDto;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class ParseVideoServiceImpl implements ParseVideoService {
    @Override
    public VideoInfoDto parseVideo(String urlText) {
        Map<String, IVideoParse> beansOfType = SpringUtil.getApplicationContext().getBeansOfType(IVideoParse.class);
        for (Map.Entry<String, IVideoParse> entry : beansOfType.entrySet()) {
            IVideoParse iVideoParse = entry.getValue();
            ParseVideoServiceAnno declaredAnnotation = iVideoParse.getClass().getDeclaredAnnotation(ParseVideoServiceAnno.class);
            String s = declaredAnnotation.searchKey();
            if (urlText.contains(s)){
                return iVideoParse.parseVideo(urlText);
            }
        }
        return null;
    }
}

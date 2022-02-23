package com.github.xcxemr.videoxcx.video.controller;

import cn.hutool.core.bean.BeanUtil;
import com.github.xcxemr.videoxcx.video.controller.vo.ParseVideoReq;
import com.github.xcxemr.videoxcx.video.controller.vo.ParseVideoResp;
import com.github.xcxemr.videoxcx.common.result.ObjectResult;
import com.github.xcxemr.videoxcx.video.service.ParseVideoService;
import com.github.xcxemr.videoxcx.video.service.dto.VideoInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/video")
public class ParseVideoController {

    @Autowired
    private ParseVideoService parseVideoService;

    @PostMapping("/parse")
    public ObjectResult<ParseVideoResp> parseVideo(@RequestBody @Valid ParseVideoReq parseVideoReq){
        VideoInfoDto videoInfoDto = parseVideoService.parseVideo(parseVideoReq.getUrlText());
        if (null == videoInfoDto){
            return ObjectResult.error(null, "解析失败，不支持当前平台，请检查输入的分享链接");
        }
        return ObjectResult.success(BeanUtil.copyProperties(videoInfoDto, ParseVideoResp.class));
    }

}

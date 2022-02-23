package com.github.xcxemr.videoxcx.video.service;

import com.github.xcxemr.videoxcx.video.service.dto.VideoInfoDto;

public interface ParseVideoService {
    VideoInfoDto parseVideo(String urlText);
}

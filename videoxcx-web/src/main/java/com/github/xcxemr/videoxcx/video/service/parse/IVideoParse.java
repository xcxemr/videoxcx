package com.github.xcxemr.videoxcx.video.service.parse;

import com.github.xcxemr.videoxcx.video.service.dto.VideoInfoDto;

public interface IVideoParse {
    VideoInfoDto parseVideo(String shareText);
}

package com.github.xcxemr.videoxcx.video.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParseVideoResp {
    private String url;
    private String author;
    private String avatar;
    private String uid;
    private Integer time;
    private String title;
    private String cover;
    private Music music;

    private List<String> images;
    /**
     * video : 视频
     * img: 图集
     */
    private String type;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Music {
        private String author;
        private String avatar;
        private String url;
    }

}

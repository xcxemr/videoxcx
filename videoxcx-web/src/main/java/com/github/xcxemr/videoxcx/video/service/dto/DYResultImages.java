package com.github.xcxemr.videoxcx.video.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class DYResultImages {

    @JsonProperty("uri")
    private String uri;
    @JsonProperty("url_list")
    private List<String> urlList;
    @JsonProperty("download_url_list")
    private List<String> downloadUrlList;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("width")
    private Integer width;
}

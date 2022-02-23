package com.github.xcxemr.videoxcx.video.controller.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ParseVideoReq {

    @NotBlank
    private String urlText;
}

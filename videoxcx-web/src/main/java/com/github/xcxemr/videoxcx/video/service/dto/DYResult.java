package com.github.xcxemr.videoxcx.video.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class DYResult {

    @JsonProperty("status_code")
    private Integer statusCode;
    @JsonProperty("item_list")
    private List<ItemListDTO> itemList;
    @JsonProperty("extra")
    private ExtraDTO extra;

    @NoArgsConstructor
    @Data
    public static class ExtraDTO {
        @JsonProperty("now")
        private Long now;
        @JsonProperty("logid")
        private String logid;
    }

    @NoArgsConstructor
    @Data
    public static class ItemListDTO {
        @JsonProperty("desc")
        private String desc;
        @JsonProperty("geofencing")
        private Object geofencing;
        @JsonProperty("group_id")
        private Long groupId;
        @JsonProperty("author")
        private AuthorDTO author;
        @JsonProperty("image_infos")
        private Object imageInfos;
        @JsonProperty("author_user_id")
        private Long authorUserId;
        @JsonProperty("from_xigua")
        private Boolean fromXigua;
        @JsonProperty("category")
        private Integer category;
        @JsonProperty("is_live_replay")
        private Boolean isLiveReplay;
        @JsonProperty("statistics")
        private StatisticsDTO statistics;
        @JsonProperty("video_labels")
        private Object videoLabels;
        @JsonProperty("duration")
        private Integer duration;
        @JsonProperty("is_preview")
        private Integer isPreview;
        @JsonProperty("share_info")
        private ShareInfoDTO shareInfo;
        @JsonProperty("risk_infos")
        private RiskInfosDTO riskInfos;
        @JsonProperty("promotions")
        private Object promotions;
        @JsonProperty("create_time")
        private Integer createTime;
        @JsonProperty("video_text")
        private Object videoText;
        @JsonProperty("images")
        private List<DYResultImages> images;
        @JsonProperty("label_top_text")
        private Object labelTopText;
        @JsonProperty("long_video")
        private Object longVideo;
        @JsonProperty("anchor_info")
        private AnchorInfoDTO anchorInfo;
        @JsonProperty("forward_id")
        private String forwardId;
        @JsonProperty("aweme_id")
        private String awemeId;
        @JsonProperty("video")
        private VideoDTO video;
        @JsonProperty("aweme_type")
        private Integer awemeType;
        @JsonProperty("share_url")
        private String shareUrl;
        @JsonProperty("text_extra")
        private List<?> textExtra;
        @JsonProperty("group_id_str")
        private String groupIdStr;
        @JsonProperty("music")
        private MusicDTO music;
        @JsonProperty("cha_list")
        private Object chaList;
        @JsonProperty("comment_list")
        private Object commentList;

        @NoArgsConstructor
        @Data
        public static class AuthorDTO {
            @JsonProperty("short_id")
            private String shortId;
            @JsonProperty("avatar_larger")
            private AvatarLargerDTO avatarLarger;
            @JsonProperty("avatar_thumb")
            private AvatarThumbDTO avatarThumb;
            @JsonProperty("unique_id")
            private String uniqueId;
            @JsonProperty("platform_sync_info")
            private Object platformSyncInfo;
            @JsonProperty("geofencing")
            private Object geofencing;
            @JsonProperty("policy_version")
            private Object policyVersion;
            @JsonProperty("type_label")
            private Object typeLabel;
            @JsonProperty("uid")
            private String uid;
            @JsonProperty("nickname")
            private String nickname;
            @JsonProperty("signature")
            private String signature;
            @JsonProperty("avatar_medium")
            private AvatarMediumDTO avatarMedium;
            @JsonProperty("followers_detail")
            private Object followersDetail;

            @NoArgsConstructor
            @Data
            public static class AvatarLargerDTO {
                @JsonProperty("uri")
                private String uri;
                @JsonProperty("url_list")
                private List<String> urlList;
            }

            @NoArgsConstructor
            @Data
            public static class AvatarThumbDTO {
                @JsonProperty("uri")
                private String uri;
                @JsonProperty("url_list")
                private List<String> urlList;
            }

            @NoArgsConstructor
            @Data
            public static class AvatarMediumDTO {
                @JsonProperty("uri")
                private String uri;
                @JsonProperty("url_list")
                private List<String> urlList;
            }
        }

        @NoArgsConstructor
        @Data
        public static class StatisticsDTO {
            @JsonProperty("aweme_id")
            private String awemeId;
            @JsonProperty("comment_count")
            private Integer commentCount;
            @JsonProperty("digg_count")
            private Integer diggCount;
            @JsonProperty("play_count")
            private Integer playCount;
            @JsonProperty("share_count")
            private Integer shareCount;
        }

        @NoArgsConstructor
        @Data
        public static class ShareInfoDTO {
            @JsonProperty("share_weibo_desc")
            private String shareWeiboDesc;
            @JsonProperty("share_desc")
            private String shareDesc;
            @JsonProperty("share_title")
            private String shareTitle;
        }

        @NoArgsConstructor
        @Data
        public static class RiskInfosDTO {
            @JsonProperty("type")
            private Integer type;
            @JsonProperty("content")
            private String content;
            @JsonProperty("reflow_unplayable")
            private Integer reflowUnplayable;
            @JsonProperty("warn")
            private Boolean warn;
        }

        @NoArgsConstructor
        @Data
        public static class AnchorInfoDTO {
            @JsonProperty("type")
            private Integer type;
            @JsonProperty("id")
            private String id;
            @JsonProperty("name")
            private String name;
        }

        @NoArgsConstructor
        @Data
        public static class VideoDTO {
            @JsonProperty("origin_cover")
            private OriginCoverDTO originCover;
            @JsonProperty("bit_rate")
            private Object bitRate;
            @JsonProperty("vid")
            private String vid;
            @JsonProperty("is_long_video")
            private Integer isLongVideo;
            @JsonProperty("dynamic_cover")
            private DynamicCoverDTO dynamicCover;
            @JsonProperty("cover")
            private CoverDTO cover;
            @JsonProperty("height")
            private Integer height;
            @JsonProperty("width")
            private Integer width;
            @JsonProperty("ratio")
            private String ratio;
            @JsonProperty("has_watermark")
            private Boolean hasWatermark;
            @JsonProperty("duration")
            private Integer duration;
            @JsonProperty("play_addr")
            private PlayAddrDTO playAddr;

            @NoArgsConstructor
            @Data
            public static class OriginCoverDTO {
                @JsonProperty("uri")
                private String uri;
                @JsonProperty("url_list")
                private List<String> urlList;
            }

            @NoArgsConstructor
            @Data
            public static class DynamicCoverDTO {
                @JsonProperty("url_list")
                private List<String> urlList;
                @JsonProperty("uri")
                private String uri;
            }

            @NoArgsConstructor
            @Data
            public static class CoverDTO {
                @JsonProperty("uri")
                private String uri;
                @JsonProperty("url_list")
                private List<String> urlList;
            }

            @NoArgsConstructor
            @Data
            public static class PlayAddrDTO {
                @JsonProperty("uri")
                private String uri;
                @JsonProperty("url_list")
                private List<String> urlList;
            }
        }

        @NoArgsConstructor
        @Data
        public static class MusicDTO {
            @JsonProperty("author")
            private String author;
            @JsonProperty("cover_large")
            private CoverLargeDTO coverLarge;
            @JsonProperty("cover_medium")
            private CoverMediumDTO coverMedium;
            @JsonProperty("play_url")
            private PlayUrlDTO playUrl;
            @JsonProperty("duration")
            private Integer duration;
            @JsonProperty("status")
            private Integer status;
            @JsonProperty("id")
            private Long id;
            @JsonProperty("mid")
            private String mid;
            @JsonProperty("title")
            private String title;
            @JsonProperty("cover_hd")
            private CoverHdDTO coverHd;
            @JsonProperty("cover_thumb")
            private CoverThumbDTO coverThumb;
            @JsonProperty("position")
            private Object position;

            @NoArgsConstructor
            @Data
            public static class CoverLargeDTO {
                @JsonProperty("uri")
                private String uri;
                @JsonProperty("url_list")
                private List<String> urlList;
            }

            @NoArgsConstructor
            @Data
            public static class CoverMediumDTO {
                @JsonProperty("uri")
                private String uri;
                @JsonProperty("url_list")
                private List<String> urlList;
            }

            @NoArgsConstructor
            @Data
            public static class PlayUrlDTO {
                @JsonProperty("uri")
                private String uri;
                @JsonProperty("url_list")
                private List<String> urlList;
            }

            @NoArgsConstructor
            @Data
            public static class CoverHdDTO {
                @JsonProperty("uri")
                private String uri;
                @JsonProperty("url_list")
                private List<String> urlList;
            }

            @NoArgsConstructor
            @Data
            public static class CoverThumbDTO {
                @JsonProperty("uri")
                private String uri;
                @JsonProperty("url_list")
                private List<String> urlList;
            }
        }
    }
}

package com.github.xcxemr.videoxcx.video.service.parse;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.github.xcxemr.videoxcx.video.anno.ParseVideoServiceAnno;
import com.github.xcxemr.videoxcx.video.service.dto.DYResult;
import com.github.xcxemr.videoxcx.video.service.dto.DYResultImages;
import com.github.xcxemr.videoxcx.video.service.dto.VideoInfoDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ParseVideoServiceAnno(searchKey = "douyin")
@Component
public class DouYinVideoParse extends AbstractVideoParse {

    private static final String UA = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36";

    private static final Pattern douyin_pattern2 = Pattern.compile("/video/(.*)/\\?");
    private static final String douyin_url = "https://www.iesdouyin.com/web/api/v2/aweme/iteminfo/?item_ids=";

    @Override
    public VideoInfoDto parseVideo(String shareText) {
        List<String> urls = findUrlStr(shareText);
        if (CollUtil.isNotEmpty(urls)) {
            String url = urls.get(0);
            HttpResponse response1 = HttpRequest.get(url)
                    .header(Header.USER_AGENT, UA)
                    .execute();
            if (response1.getStatus() == 302) {
                String location = response1.header("location");
                Matcher matcher = douyin_pattern2.matcher(location);
                if (matcher.find()) {
                    String videoId = matcher.group(1);
                    String url2 = douyin_url + videoId;
                    HttpResponse execute = HttpRequest.get(url2).header(Header.USER_AGENT, UA).execute();
                    if (execute.isOk()) {
                        String body = execute.body();
                        DYResult dyResult = JSONUtil.toBean(body, DYResult.class);
                        VideoInfoDto infoDto = new VideoInfoDto();

                        infoDto.setAuthor(dyResult.getItemList().get(0).getAuthor().getNickname());
                        infoDto.setAvatar(dyResult.getItemList().get(0).getAuthor().getAvatarLarger().getUrlList().get(0));
                        infoDto.setUid(dyResult.getItemList().get(0).getAuthor().getUid());
                        infoDto.setTime(dyResult.getItemList().get(0).getCreateTime());
                        infoDto.setTitle(dyResult.getItemList().get(0).getShareInfo().getShareTitle());
                        infoDto.setCover(dyResult.getItemList().get(0).getVideo().getOriginCover().getUrlList().get(0));
                        VideoInfoDto.Music music = new VideoInfoDto.Music();
                        music.setAuthor(dyResult.getItemList().get(0).getMusic().getAuthor());
                        if (CollUtil.isNotEmpty(dyResult.getItemList().get(0).getMusic().getCoverLarge().getUrlList())) {
                            music.setAvatar(dyResult.getItemList().get(0).getMusic().getCoverLarge().getUrlList().get(0));
                        }
                        if (CollUtil.isNotEmpty(dyResult.getItemList().get(0).getMusic().getPlayUrl().getUrlList())) {
                            music.setUrl(dyResult.getItemList().get(0).getMusic().getPlayUrl().getUrlList().get(0));
                        }
                        infoDto.setMusic(music);

                        if (CollUtil.size(dyResult.getItemList().get(0).getImages()) > 0) {
                            // 是图片
                            List<String> images = new ArrayList<>();
                            for (DYResultImages image : dyResult.getItemList().get(0).getImages()) {
                                String s = image.getUrlList().get(0);
                                images.add(s);
                            }
                            infoDto.setImages(images);
                            infoDto.setType("img");
                            return infoDto;
                        } else {
                            String videoUrl = dyResult.getItemList().get(0).getVideo().getPlayAddr().getUrlList().get(0);
                            videoUrl = videoUrl.replace("playwm", "play");
                            HttpResponse execute1 = HttpRequest.get(videoUrl).header(Header.USER_AGENT, UA).execute();
                            if (execute1.getStatus() == 302) {
                                String realUrl = execute1.header("location");
                                infoDto.setUrl(realUrl);
                                infoDto.setType("video");
                                return infoDto;
                            }
                        }

                    }
                }
            }
        }
        return null;
    }
}

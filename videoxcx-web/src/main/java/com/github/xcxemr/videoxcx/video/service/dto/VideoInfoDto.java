package com.github.xcxemr.videoxcx.video.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoInfoDto {
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
    public static class Music{
        private String author;
        private String avatar;
        private String url;
    }

//    public function douyin($url)
//    {
//        $loc = get_headers($url, true)['Location'][1];
//        preg_match('/video\/(.*)\?/', $loc, $id);
//        $arr = json_decode($this->curl('https://www.iesdouyin.com/web/api/v2/aweme/iteminfo/?item_ids=' . $id[1]),true);
//        preg_match('/href="(.*?)">Found/',$this->curl(str_replace('playwm', 'play',$arr['item_list'][0]["video"]["play_addr"]["url_list"][0])),$matches);
//        $video_url = str_replace('&', '&', $matches[1]);
//        if ($video_url) {
//            $arr = [
//            'code' => 200,
//                    'msg'  => '解析成功',
//                    'data' => [
//            'author' => $arr['item_list'][0]['author']['nickname'],
//                    'uid'    => $arr['item_list'][0]['author']['unique_id'],
//                    'avatar' => $arr['item_list'][0]['author']['avatar_larger']['url_list'][0],
//                    'like'   => $arr['item_list'][0]['statistics']['digg_count'],
//                    'time'   => $arr['item_list'][0]["create_time"],
//                    'title'  => $arr['item_list'][0]['share_info']['share_title'],
//                    'cover'  => $arr['item_list'][0]['video']['origin_cover']['url_list'][0],
//                    'url'    => $video_url,
//                    'music'  => [
//            'author' => $arr['item_list'][0]['music']['author'],
//                    'avatar' => $arr['item_list'][0]['music']['cover_large']['url_list'][0],
//                    'url'    => $arr['item_list'][0]['music']['play_url']['url_list'][0],
//                    ]
//                ]
//            ];
//            return $arr;
//        }
//    }

}

package com.github.xcxemr.videoxcx.video.service.parse;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractVideoParse implements IVideoParse{

    private static final Pattern uri_pattern = Pattern.compile("(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]");


    public List<String> findUrlStr(String data) {
        Matcher matcher = uri_pattern.matcher(data);
        List<String> result = new ArrayList<>();
        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }


}

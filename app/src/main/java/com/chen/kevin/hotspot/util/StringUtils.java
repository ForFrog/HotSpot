package com.chen.kevin.hotspot.util;

import java.util.List;

public class StringUtils {


    public static StringBuilder formatStringList(List<String> text) {
        StringBuilder sb = new StringBuilder();
        for (String t : text) {
            sb.append(t).append("/");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb;
    }

}

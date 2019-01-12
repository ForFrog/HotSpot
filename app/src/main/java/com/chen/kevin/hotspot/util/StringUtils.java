package com.chen.kevin.hotspot.util;

import java.util.List;
import java.util.Locale;

public class StringUtils {


    public static StringBuilder formatStringList(List<String> text) {
        StringBuilder sb = new StringBuilder();
        for (String t : text) {
            sb.append(t).append("/");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb;
    }


    public static String formatNumber(int num) {
        if (num > 1000) {
            float collectCount = (float) num / 1000;
            return String.format(Locale.CHINA, "%.1f", collectCount) + "k";

        } else {
            return String.valueOf(num);
        }

    }
}

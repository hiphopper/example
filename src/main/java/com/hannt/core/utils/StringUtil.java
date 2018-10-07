package com.hannt.core.utils;

import org.springframework.util.StringUtils;

/**
 * 내사에서 사용되는 String 관련 Util
 */
public class StringUtil {
    public static boolean isEmpty(String str){
        return StringUtils.isEmpty(str);
    }

    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}

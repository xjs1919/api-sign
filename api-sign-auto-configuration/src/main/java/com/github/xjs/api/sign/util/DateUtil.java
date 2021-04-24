package com.github.xjs.api.sign.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jiashuai.xu
 * @date 2021/4/16 10:49 上午
 */
public class DateUtil {

    public static String format(Date date, String yyyyMMddHHmm) {
        SimpleDateFormat sdf = new SimpleDateFormat(yyyyMMddHHmm);
        return sdf.format(date);
    }
}

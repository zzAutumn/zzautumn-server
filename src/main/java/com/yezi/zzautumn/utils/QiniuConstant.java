package com.yezi.zzautumn.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: yezi
 * @Date: 2019/3/16 12 37
 * @Description:
 */
@Component
@ConfigurationProperties(prefix = "qiniu")
public interface QiniuConstant {

    String accessKey = "9pfFfvLu87U9yfkBiDrq-X0XVryeKDLT2XDklrj_";
    String secretKey = "yuMDDwksHcPvHa0N0HDLMeY06LWC2cLWZnAXyVKy";
    String bucket = "autumnzz";
    String path = "http://blog.img.zzautumn.cn";
}

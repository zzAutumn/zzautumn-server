package com.yezi.zzautumn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @Author: yezi
 * @Date: 2019/3/17 17 48
 * @Description:
 */
@Configuration
public class GlobalCorsConfig {

    @Bean
    public CorsFilter corsFilter () {
        // 1.添加cors配置信息
        CorsConfiguration configuration = new CorsConfiguration();
        // 放行哪些域
        configuration.addAllowedOrigin("*");
        // 是否发送Cookie信息
        configuration.setAllowCredentials(true);
        // 放行哪些原始域(请求方式)
        configuration.addAllowedMethod("*");
        // 放行哪些原始域头部信息
        configuration.addAllowedHeader("*");
        configuration.addExposedHeader("*");

        // 2.添加映射路由
        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**", configuration);

        // 3.返回新的cordfilter
        return new CorsFilter(configurationSource);
    }
}

package com.soft1851.music.admin.config;

import com.soft1851.music.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author Tao
 * @version 1.0
 * @ClassName WebConfig
 * @Description 注册拦截器等Web配置
 * @date 2020-04-21 16:06
 **/
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Resource
    private LoginInterceptor loginInterceptor;
    /**
     * 添加拦截器配置
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截路径可自行配置多个 可用 ，分隔开
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/login","/captcha","/roleMenu/*","/songList/*","/sysAdmin/*","/roleMenu/all/*").excludePathPatterns("/static/**");
    }
}

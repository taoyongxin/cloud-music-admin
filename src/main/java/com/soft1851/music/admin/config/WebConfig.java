package com.soft1851.music.admin.config;

import com.soft1851.music.admin.interceptor.LoginInterceptor;
import com.soft1851.music.admin.interceptor.TokenInterceptor;
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
    @Resource
    private TokenInterceptor tokenInterceptor;
    /**
     * 添加拦截器配置
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截路径可自行配置多个 可用 ，分隔开
//        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
//                .excludePathPatterns("/login","/captcha","/roleMenu/*","/songList/*","/sysAdmin/*","/roleMenu/all/*")
//                .excludePathPatterns("/static/**");

        //JWT拦截器，放行登录和验证码接口
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/sysAdmin/login","/captcha")
                .excludePathPatterns("/static/**");
        //验证码拦截器，拦截登录接口
        registry.addInterceptor(loginInterceptor).addPathPatterns("/sysAdmin/login");
    }
}

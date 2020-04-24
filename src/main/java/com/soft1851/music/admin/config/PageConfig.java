package com.soft1851.music.admin.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tao
 * @version 1.0
 * @ClassName PageConfig
 * @Description 分页插件
 * @date 2020-04-24 10:39
 **/
@Configuration
public class PageConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}

package com.soft1851.music.admin.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author Tao
 * @version 1.0
 * @ClassName CaptchaConfig
 * @Description Captcha配置类
 * @date 2020-04-21 10:59
 **/
@Configuration
public class CaptchaConfig {
    @Bean
    public DefaultKaptcha defaultKaptcha(){
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        //设置字符长度
        properties.setProperty("kaptcha.textproducer.char.length","6");
        //设置边框
        properties.setProperty("kaptcha.border","yes");
        //设置颜色
        properties.setProperty("kaptcha.border.color","22,117,255");
        //设置文本的生产者
        properties.setProperty("kaptcha.textproducer.font.color","red");
        //设置字体大小
        properties.setProperty("kaptcha.textproducer.font.size","30");
        properties.setProperty("kaptcha.textproducer.font.names","微软雅黑,楷体,宋体");
        //设置图片大小
        properties.setProperty("kaptcha.image.width","120");
        properties.setProperty("kaptcha.image.height","45");
        //会话级别内容的存取
        properties.setProperty("kaptcha.session.key","code");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}

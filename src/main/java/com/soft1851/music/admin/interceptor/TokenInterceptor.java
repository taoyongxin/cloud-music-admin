package com.soft1851.music.admin.interceptor;

import com.soft1851.music.admin.common.ResultCode;
import com.soft1851.music.admin.exception.CustomException;
import com.soft1851.music.admin.service.SysAdminService;
import com.soft1851.music.admin.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Tao
 * @version 1.0
 * @ClassName JwtInterceptor
 * @Description jwt拦截器
 * @date 2020-04-22 9:54
 **/
@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Resource
    private SysAdminService sysAdminService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if(token == null){
            log.info("### 用户未登录，请先登录 ###");
            throw new CustomException("用户未登录，请先登录", ResultCode.USER_NOT_SIGN_IN);
        }else {
            log.info("## token= {}", token);
            // 认证
            if (JwtTokenUtil.isExpiration(token)) {
                log.info("##  token已失效  ##");
                // 通过自定义异常抛出token失效的信息，由全局统一处理
                throw new CustomException("token失效", ResultCode.USER_TOKEN_EXPIRES);
            } else {
                //通过认证，放行到controller层
                return true;
            }
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

package com.soft1851.music.admin.interceptor;

import com.alibaba.fastjson.JSONArray;
import com.soft1851.music.admin.common.ResultCode;
import com.soft1851.music.admin.domain.entity.SysRole;
import com.soft1851.music.admin.exception.CustomException;
import com.soft1851.music.admin.service.RedisService;
import com.soft1851.music.admin.service.SysRoleService;
import com.soft1851.music.admin.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    private SysRoleService sysRoleService;
    @Resource
    private RedisService redisService;

    /**
     * 前置拦截
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token == null) {
            log.info("### 用户未登录，请先登录 ###");
            //通过自定义异常抛出未登录的信息，由全局统一处理
            throw new CustomException("用户未登录，请先登录", ResultCode.USER_NOT_SIGN_IN);
        } else {
            //已经登录
            log.info("## token= {}", token);
            /*********/
            //从请求头中取出id
            String adminId = request.getHeader("id");
            log.info("## id= {}",adminId);
            //到redis中检查是否存在以adminId为key的数据，如果不存在，要么过期了要么不是这个id的用户
            if (!redisService.existsKey(adminId)){
                log.info("### 用户认证失败 ###");
                throw new CustomException("用户认证失败",ResultCode.USER_AUTH_ERROR);
            }
            //用这个secrect私钥从token中解析出roles字符串
            String secrect = redisService.getValue(adminId,String.class);
            String roles = JwtTokenUtil.getRoles(token,secrect);
            log.info("## roles= {}",roles);
            /**********/
            //反序列化为list
            List<SysRole> roleList = JSONArray.parseArray(roles, SysRole.class);
            //从request中取得客户端传输的roleId
            String roleId = request.getParameter("roleId");
            log.info("## roleId={}", roleId);
            //到roles中查找比对，此部分代码在sysRoleService
            boolean flag = sysRoleService.checkRole(roleList, Integer.parseInt(roleId));
            log.info("## flag= {}", flag);
            // 在token中解析出的roles中含有请求参数的role的值，方形到controller中获取参数
            if (flag) {
                return true;
            } else {
                log.info("### 用户权限不足 ###");
                //通过自定义异常抛出权限不足的信息，由全局统一处理
                throw new CustomException("用户权限不足", ResultCode.PERMISSION_NO_ACCESS);
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

package com.soft1851.music.admin.controller;


import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.common.ResultCode;
import com.soft1851.music.admin.dto.LoginDto;
import com.soft1851.music.admin.entity.SysAdmin;
import com.soft1851.music.admin.service.SysAdminService;
import com.soft1851.music.admin.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tao
 * @since 2020-04-21
 */
@RestController
@RequestMapping("/sysAdmin")
@Slf4j
public class SysAdminController {
    @Resource
    private SysAdminService sysAdminService;

    /**
     * 登录
     * @return String
     */
    @PostMapping("/login")
    public ResponseResult login(@RequestBody LoginDto loginDto) {
        log.info(loginDto.toString());
        boolean login = sysAdminService.login(loginDto);
        if (login) {
            SysAdmin admin = sysAdminService.getAdmin(loginDto.getName());
            return ResponseResult.success(JwtTokenUtil.getToken(loginDto.getName(), admin.getId(), new Date(System.currentTimeMillis() + 60L * 60L * 1000L)));
        } else {
            return ResponseResult.failure(ResultCode.USER_SIGN_IN_FAIL);
        }
    }



    /**
     * 根据帐号查出角色身份
     * @param name
     * @return
     */
    @GetMapping(value = "/{name}")
    public ResponseResult getRoleByName(@PathVariable String name){
        return sysAdminService.getRoleByName(name);
    }
    //    @GetMapping("/role")
//    public ResponseResult getRoleByName(@Param("name") String name){
//        return sysAdminService.getRoleByName(name);
//    }

}

package com.soft1851.music.admin.service;

import com.soft1851.music.admin.CloudMusicAdminApplication;
import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.dto.LoginDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = CloudMusicAdminApplication.class)
class SysAdminServiceTest {

    @Resource
    private SysAdminService sysAdminService;
    @Test
    void login() {
        LoginDto loginDto = LoginDto.builder()
                .name("mqxu")
                .password("123456.")
                .build();
        boolean result = sysAdminService.login(loginDto);
        System.out.println(result);
    }

    @Test
    void getAdmin() {
        System.out.println(sysAdminService.getAdmin("mqxu"));
    }

    @Test
    void getRoleByName() {
        ResponseResult responseResult = sysAdminService.getRoleByName("soft1851");
        System.out.println(responseResult);
    }
}
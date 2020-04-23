package com.soft1851.music.admin.service;

import com.soft1851.music.admin.CloudMusicAdminApplication;
import com.soft1851.music.admin.dto.LoginDto;
import com.soft1851.music.admin.entity.SysAdmin;
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
    void getAdminRolesByName() {
        SysAdmin sysAdmin = sysAdminService.getAdminRolesByName("mqxu");
        System.out.println(sysAdmin);
    }
}
package com.soft1851.music.admin.service;

import com.soft1851.music.admin.CloudMusicAdminApplication;
import com.soft1851.music.admin.domain.entity.SysAdmin;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = CloudMusicAdminApplication.class)
class SysAdminServiceTest {

    @Resource
    private SysAdminService sysAdminService;

    @Test
    void getAdminRolesByName() {
        SysAdmin sysAdmin = sysAdminService.getAdminRolesByName("mqxu");
        System.out.println(sysAdmin);
    }
}
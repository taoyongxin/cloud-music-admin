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

    @Test
    void updateSysAdmin() {
        SysAdmin sysAdmin = new SysAdmin();
        sysAdmin.setId("DE35D7CC05AF96A21D7ADFC8651E6614");
        sysAdmin.setName("mqxu");
        sysAdmin.setPassword("12345");
        sysAdmin.setAvatar("测试头像");
        sysAdminService.updateSysAdmin(sysAdmin);
    }
}
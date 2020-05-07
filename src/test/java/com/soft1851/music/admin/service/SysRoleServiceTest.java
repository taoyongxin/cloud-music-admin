package com.soft1851.music.admin.service;

import com.soft1851.music.admin.CloudMusicAdminApplication;
import com.soft1851.music.admin.domain.entity.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = CloudMusicAdminApplication.class)
class SysRoleServiceTest {

    @Resource
    private SysRoleService sysRoleService;
    @Test
    void selectRoleById() {
        Map<String,Object> map = sysRoleService.selectRoleById(1);
        System.out.println(map);
    }


    @Test
    void selectAll() {
        List<SysRole> sysRoles = sysRoleService.selectAll();
        System.out.println(sysRoles);
    }
}
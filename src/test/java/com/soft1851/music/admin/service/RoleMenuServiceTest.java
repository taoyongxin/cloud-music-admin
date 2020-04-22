package com.soft1851.music.admin.service;

import com.soft1851.music.admin.CloudMusicAdminApplication;
import com.soft1851.music.admin.common.ResponseResult;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
@SpringBootTest(classes = CloudMusicAdminApplication.class)
class RoleMenuServiceTest {
    @Resource
    private RoleMenuService roleMenuService;

    @Test
    void getMenusByName() {
        ResponseResult responseResult = roleMenuService.getMenusByName("soft1851");
        System.out.println(responseResult);
    }

    @Test
    void getParentMenuByRoleId() {
        ResponseResult responseResult = roleMenuService.getParentMenuByRoleId(2);
        System.out.println(responseResult);
    }


}
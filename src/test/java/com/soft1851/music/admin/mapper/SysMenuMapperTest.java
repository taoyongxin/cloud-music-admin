package com.soft1851.music.admin.mapper;

import com.soft1851.music.admin.CloudMusicAdminApplication;
import com.soft1851.music.admin.entity.SysMenu;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest(classes = CloudMusicAdminApplication.class)
class SysMenuMapperTest {


    @Resource
    private SysMenuMapper sysMenuMapper;

    @Test
    void getMenuByParentId() throws SQLException {
        List<SysMenu> sysMenuList = sysMenuMapper.getMenuByParentId(0);
        System.out.println(sysMenuList);
    }
}
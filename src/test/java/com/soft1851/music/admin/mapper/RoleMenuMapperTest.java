package com.soft1851.music.admin.mapper;

import com.soft1851.music.admin.CloudMusicAdminApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = CloudMusicAdminApplication.class)
class RoleMenuMapperTest {

    @Resource
    private RoleMenuMapper roleMenuMapper;

    @Test
    void getParentMenuByRoleId() throws SQLException {
        List<Map> mapList = roleMenuMapper.getParentMenuByRoleId(1);
        System.out.println(mapList);
    }
}
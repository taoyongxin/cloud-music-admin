package com.soft1851.music.admin.mapper;

import com.soft1851.music.admin.CloudMusicAdminApplication;
import com.soft1851.music.admin.entity.SysAdmin;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = CloudMusicAdminApplication.class)
class SysAdminMapperTest {

    @Resource
    private SysAdminMapper sysAdminMapper;
//    @Test
//    void getSysAdminByName() throws SQLException {
//        SysAdmin sysAdmin = sysAdminMapper.getSysAdminByName("mqxu");
//        System.out.println(sysAdmin);
//    }

    @Test
    void getAdminMenuByAdminId() throws SQLException{
        Map map = sysAdminMapper.getAdminMenuByAdminId("22516FB6A9D389D7FC21420806150A7B");
        System.out.println(map);
    }

    @Test
    void getRoleByAdminId() throws SQLException{
        List<Map> mapList = sysAdminMapper.getRoleByName("soft1851");
        System.out.println(mapList);
    }
}
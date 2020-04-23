package com.soft1851.music.admin.mapper;

import com.soft1851.music.admin.CloudMusicAdminApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
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
    void getRoleByAdminId() throws SQLException{
        List<Map> mapList = sysAdminMapper.getRoleByAdminId("DE35D7CC05AF96A21D7ADFC8651E6614");
        System.out.println(mapList);
    }

}
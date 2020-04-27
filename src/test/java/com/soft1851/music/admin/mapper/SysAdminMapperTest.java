package com.soft1851.music.admin.mapper;

import com.soft1851.music.admin.CloudMusicAdminApplication;
import com.soft1851.music.admin.domain.entity.SysAdmin;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
@SpringBootTest(classes = CloudMusicAdminApplication.class)
class SysAdminMapperTest {

    @Resource
    private SysAdminMapper sysAdminMapper;

    @Test
    void selectByName() throws SQLException{
        SysAdmin sysAdmin = sysAdminMapper.selectByName("mqxu");
        System.out.println(sysAdmin);
    }

    @Test
    void getSysAdminByName() throws SQLException{
        SysAdmin sysAdmin = sysAdminMapper.getSysAdminByName("mqxu");
        System.out.println(sysAdmin);
    }
}
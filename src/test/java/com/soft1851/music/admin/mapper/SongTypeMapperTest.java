package com.soft1851.music.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.soft1851.music.admin.CloudMusicAdminApplication;
import com.soft1851.music.admin.entity.SongType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = CloudMusicAdminApplication.class)
class SongTypeMapperTest {
    @Resource
    private SongTypeMapper songTypeMapper;

    /**
     * 根据entity条件，查询一条记录，
     * 这里和上方删除改造条件一样，只是selectOne返回的是一条实体记录，当出现多条时会报错
     */
    @Test
    void selectOne() {
        QueryWrapper<SongType> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type_id","b1bb59e0815e11ea8cd1b4b686bbf77b");
        SongType songType = songTypeMapper.selectOne(queryWrapper);
        System.out.println(songType);
    }

    /**
     * 查询全部
     */
    @Test
    void selectList() {
        List<SongType> list = songTypeMapper.selectList(null);
        System.out.println(list.size());
    }

    /**
     * 根据Wrapper条件，查询全部记录
     */
    @Test
    void selectMaps() {
        QueryWrapper<SongType> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("type_name");
        List<Map<String,Object>> maps = songTypeMapper.selectMaps(queryWrapper);
        for(Map<String,Object> map : maps){
            System.out.println(map);
        }
    }

    /**
     * 根据entity条件，查询全部记录（并分页）
     * 需要在项目中配置分页插件Page
     */
    @Test
    void selectPage() {
        Page<SongType> page = new Page<>(1,10);
        QueryWrapper<SongType> queryWrapper = new QueryWrapper<>();
        IPage<SongType> songTypeIPage = songTypeMapper.selectPage(page,queryWrapper);
        System.out.println(songTypeIPage);
    }

    @Test
    void delete() {
        QueryWrapper<SongType> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("type_name")
                .le("cong_count",1000);
        int delete = songTypeMapper.delete(queryWrapper);
    }
}
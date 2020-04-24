package com.soft1851.music.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.soft1851.music.admin.CloudMusicAdminApplication;
import com.soft1851.music.admin.entity.SongType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = CloudMusicAdminApplication.class)
class SongTypeServiceTest {

    @Resource
    private SongTypeService songTypeService;
    @Test
    void getSongTypeByPage() {
        Page<SongType> page = new Page<>(1, 2, 10);
        QueryWrapper<SongType> wrapper = new QueryWrapper<>(null);
        IPage<SongType> page1 = songTypeService.page(page, wrapper);
        System.out.println(page1.getRecords());
    }
}
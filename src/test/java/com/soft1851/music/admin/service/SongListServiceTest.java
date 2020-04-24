package com.soft1851.music.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.soft1851.music.admin.CloudMusicAdminApplication;
import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.dto.PageDto;
import com.soft1851.music.admin.entity.SongList;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = CloudMusicAdminApplication.class)
class SongListServiceTest {

    @Resource
    private SongListService songListService;

    @Test
    void getAllSongList() {
        PageDto pageDto = PageDto.builder()
                .currentPage(1)
                .pageSize(3)
                .build();
        ResponseResult result = songListService.getAllSongList(pageDto);
        System.out.println(result);
    }

    /**
     * 需要加分页的插件
     */
    @Test
    void getByPage() {
        Page<SongList> page = new Page<>(1, 2, 10);
        QueryWrapper<SongList> wrapper = new QueryWrapper<>(null);
        IPage<SongList> page1 = songListService.page(page, wrapper);
        System.out.println(page1.getRecords());
//        List<SongList> songLists = songListService.getByPage(1,2);
//        System.out.println(songLists);
    }
}
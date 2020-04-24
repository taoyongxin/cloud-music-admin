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
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = CloudMusicAdminApplication.class)
class SongListServiceTest {

    @Resource
    private SongListService songListService;


    /**
     * 需要加分页的插件
     */
    @Test
    void getByPage() {
        Page<SongList> page = new Page<>(1, 2, 10);
        QueryWrapper<SongList> wrapper = new QueryWrapper<>(null);
        IPage<SongList> page1 = songListService.page(page, wrapper);
        System.out.println(page1.getRecords());
    }

    @Test
    void fuzzySearch() {
        List<SongList> songLists = songListService.fuzzySearch("摇滚");
        System.out.println(songLists);
    }

    @Test
    void selectAll() {
        List<Map<String,Object>> mapList = songListService.selectAll();
        System.out.println(mapList);
    }

    /**
     * 批量删除
     */
    @Test
    void batchDeleteById() {
        String id = "100305590,101928470";
        songListService.batchDeleteById(id);
    }

    @Test
    void searchSongList() {
        PageDto pageDto = PageDto.builder()
                .currentPage(1)
                .pageSize(3)
                .field("欧美")
                .build();
        ResponseResult result = songListService.searchSongList(pageDto);
        System.out.println(result);
    }
}
package com.soft1851.music.admin.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.soft1851.music.admin.CloudMusicAdminApplication;
import com.soft1851.music.admin.dto.PageDto;
import com.soft1851.music.admin.entity.SongList;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
@SpringBootTest(classes = CloudMusicAdminApplication.class)
class SongListMapperTest {
    @Resource
    private SongListMapper songListMapper;

    @Test
    void getAllSongList() throws SQLException {
        PageDto pageDto = PageDto.builder()
                .currentPage(1)
                .pageSize(3)
                .build();
        List<Map<String,Object>> mapList = songListMapper.getAllSongList(pageDto);
        System.out.println(mapList);
    }

    @Test
    void selectPage() {
        Page<SongList> page = new Page<>(1,3,true);
        QueryWrapper<SongList> queryWrapper = new QueryWrapper<>();
        IPage<SongList> songListIPage = songListMapper.selectPage(page,queryWrapper);
        List<SongList> songLists = songListIPage.getRecords();
        System.out.println(songLists);
    }
}
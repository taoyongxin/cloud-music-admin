package com.soft1851.music.admin.service;

import com.soft1851.music.admin.CloudMusicAdminApplication;
import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.dto.PageDto;
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
}
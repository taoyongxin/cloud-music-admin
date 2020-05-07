package com.soft1851.music.admin.mapper;

import com.soft1851.music.admin.CloudMusicAdminApplication;
import com.soft1851.music.admin.domain.entity.Song;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest(classes = CloudMusicAdminApplication.class)
class SongMapperTest {
    @Resource
    private SongMapper songMapper;
    @Test
    void selectTop() {
        List<Song> songs = songMapper.selectTop();
        System.out.println(songs.size());
    }
}
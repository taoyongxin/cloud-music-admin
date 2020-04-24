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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@SpringBootTest(classes = CloudMusicAdminApplication.class)
class SongListMapperTest {
    @Resource
    private SongListMapper songListMapper;


    @Test
    void selectPage() {
        Page<SongList> page = new Page<>(1,3,true);
        QueryWrapper<SongList> queryWrapper = new QueryWrapper<>();
        IPage<SongList> songListIPage = songListMapper.selectPage(page,queryWrapper);
        List<SongList> songLists = songListIPage.getRecords();
        System.out.println(songLists);
    }

    /**
     *
     * @throws SQLException
     */
    @Test
    void testDeleteById() throws SQLException {
        int result = songListMapper.deleteById(100827084);
        System.out.println(result);
    }

    @Test
    void testUpdate() {
        //根据id查出用户数据
        SongList songList = songListMapper.selectById(101003590);
        songList.setSongListName("测试修改歌单名");
        songList.updateById();
    }

    /**
     * 批量删除
     */
    @Test
    void testDeleteBatchIds() throws SQLException{
        String str = "102008316,102727970,102760137";
        String[] st1 = str.split(",");
        List<String> allIds = new ArrayList<>();
        for (int i = 0;i<st1.length;i++){
            allIds.add(st1[i]);
        }
        int result = songListMapper.deleteBatchIds(allIds);
        System.out.println(result);
    }

    @Test
    void searchSongList() throws SQLException{
        PageDto pageDto = PageDto.builder()
                .currentPage(1)
                .pageSize(5)
                .field("欧美")
                .build();
        List<SongList> lists = songListMapper.searchSongList(pageDto);
        System.out.println(lists);
    }
}
package com.soft1851.music.admin.controller;


import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.domain.dto.PageDto;
import com.soft1851.music.admin.domain.entity.SongList;
import com.soft1851.music.admin.service.SongListService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tao
 * @since 2020-04-21
 */
@RestController
@Slf4j
@RequestMapping("/songList")
@Validated
public class SongListController {
    @Resource
    private SongListService songListService;

    /**
     * 分页查询歌单数据
     * @param pageDto
     * @return
     */
    @PostMapping("/blur/page")
    public ResponseResult getAllSongList(@RequestBody PageDto pageDto) {
        return songListService.searchSongList(pageDto);
    }

    /**
     * 分页查询歌单数据
     * @param pageDto
     * @return
     */
    @PostMapping("/page")
    public List<SongList> getSongListByPage(@RequestBody @Valid PageDto pageDto){
        log.info(pageDto.toString());
        return songListService.getByPage(pageDto);
    }

    /**
     * 根据关键字模糊查询
     * @param field
     * @return
     */
    @GetMapping("/blur")
    public List<SongList> fuzzySearch(@Valid @Param("field") @Size(min = 2,message = "关键词不得少于两个字") String field){
        return songListService.fuzzySearch(field);
    }

    /**
     * 根绝歌单id删除歌单数据
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    ResponseResult deleteSongListById(@Param("id") String id){
        return songListService.deleteSongList(id);
    }

    /**
     * 修改歌单信息
     * @param songList
     * @return
     */
    @PutMapping("/update")
    ResponseResult updateSongList(@RequestBody @Valid SongList songList){
        return songListService.updateSongList(songList);
    }

    @DeleteMapping("/batchDelete")
    ResponseResult batchDeleteById(@Param("ids") String ids){
        return songListService.batchDeleteById(ids);
    }

    @GetMapping(value = "/export")
    public void export() {
        songListService.exportData();
    }
}

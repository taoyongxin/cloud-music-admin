package com.soft1851.music.admin.controller;


import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.dto.PageDto;
import com.soft1851.music.admin.service.SongListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
public class SongListController {

    @Resource
    private SongListService songListService;
    @PostMapping("/all")
    public ResponseResult getAllSongList(@RequestBody PageDto pageDto) {
        return songListService.getAllSongList(pageDto);
    }
}

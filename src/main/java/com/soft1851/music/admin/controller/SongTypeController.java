package com.soft1851.music.admin.controller;


import com.soft1851.music.admin.dto.PageDto;
import com.soft1851.music.admin.entity.SongType;
import com.soft1851.music.admin.service.SongTypeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
@RequestMapping("/songType")
public class SongTypeController {
    @Resource
    private SongTypeService songTypeService;
    @PostMapping("/page")
    public List<SongType> getSongListByPage(@RequestBody PageDto pageDto){
        return songTypeService.getSongTypeByPage(pageDto);
    }
}

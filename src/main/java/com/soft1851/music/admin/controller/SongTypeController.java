package com.soft1851.music.admin.controller;


import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.dto.PageDto;
import com.soft1851.music.admin.entity.SongType;
import com.soft1851.music.admin.service.SongTypeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/batchDelete")
    ResponseResult batchDeleteById(@Param("ids") String ids){
        return songTypeService.batchDeleteById(ids);
    }

    /**
     * 根据关键字模糊查询
     * @param field
     * @return
     */
    @GetMapping("/blur")
    public List<SongType> fuzzySearch(@Param("field") String field){
        return songTypeService.fuzzySearch(field);
    }
}

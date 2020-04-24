package com.soft1851.music.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft1851.music.admin.dto.PageDto;
import com.soft1851.music.admin.entity.SongType;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tao
 * @since 2020-04-21
 */
public interface SongTypeService extends IService<SongType> {
    /**
     * 分页查询.
     * @param pageDto
     * @return
     */
    List<SongType> getSongTypeByPage(PageDto pageDto);
}

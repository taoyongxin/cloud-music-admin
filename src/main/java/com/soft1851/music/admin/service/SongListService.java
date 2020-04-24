package com.soft1851.music.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.dto.PageDto;
import com.soft1851.music.admin.entity.SongList;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tao
 * @since 2020-04-21
 */
public interface SongListService extends IService<SongList> {

    /**
     * 分页查询所有歌单
     * @param pageDto
     * @return
     */
    ResponseResult getAllSongList(PageDto pageDto);

    /**
     * 分页查询.
     * @param pageDto
     * @return
     */
    List<SongList> getByPage(PageDto pageDto);

    /**
     * 模糊查询
     * @param filed
     * @return
     */
    List<SongList> fuzzySearch(String filed);

    /**
     * 查询所有歌单
     * @return
     */
    List<Map<String, Object>> selectAll();
}

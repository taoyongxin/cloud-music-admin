package com.soft1851.music.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft1851.music.admin.domain.entity.Song;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tao
 * @since 2020-04-21
 */
public interface SongMapper extends BaseMapper<Song> {
    /**
     * 查询歌曲
     *
     * @return
     */
    @Select("SELECT * FROM song  ORDER BY  song_id  LIMIT 100 ")
    List<Song> selectTop();
}

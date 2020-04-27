package com.soft1851.music.admin.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.soft1851.music.admin.annotation.ExcelVoAttribute;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author tao
 * @since 2020-04-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("song_list")
public class SongList extends Model<SongList> {

    private static final long serialVersionUID = 1L;

    /**
     * 歌单id
     */
    @ExcelVoAttribute(name = "歌单ID",column = 0)
    @TableId("song_list_id")
    private String songListId;

    /**
     * 歌单名称
     */
    @ExcelVoAttribute(name = "歌单名称",column = 1)
    @TableField("song_list_name")
    private String songListName;

    /**
     * 封面
     */
    @ExcelVoAttribute(name = "歌单封面图",column = 2)
    @TableField("thumbnail")
    private String thumbnail;

    /**
     * 歌单类型
     */
    @TableField("type")
    private String type;

    /**
     * 歌曲数
     */
    @ExcelVoAttribute(name = "歌曲数",column = 3,isNumber = true)
    @TableField("song_count")
    private BigDecimal songCount;

    /**
     * 收藏数
     */
    @ExcelVoAttribute(name = "收藏数",column = 4,isNumber = true)
    @TableField("like_count")
    private BigDecimal likeCount;

    /**
     * 评论数
     */
    @ExcelVoAttribute(name = "评论数",column = 5,isNumber = true)
    @TableField("comment_count")
    private BigDecimal commentCount;

    /**
     * 删除标志
     */
    @TableField("delete_flag")
    private Integer deleteFlag;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    @ExcelVoAttribute(name = "创建时间",column = 6,isDateTime = true)
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 播放量
     */
    @TableField("play_counts")
    private Integer playCounts;


    @Override
    protected Serializable pkVal() {
        return this.songListId;
    }

}

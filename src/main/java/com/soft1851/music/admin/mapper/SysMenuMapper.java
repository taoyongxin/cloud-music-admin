package com.soft1851.music.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft1851.music.admin.domain.entity.SysMenu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tao
 * @since 2020-04-21
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    /**
     * 根据父类id查询菜单数据
     * @param parentId
     * @return
     * @throws SQLException
     */
    @Select("SELECT * FROM sys_menu WHERE parent_id = #{parentId} ORDER BY sort")
    List<SysMenu> getMenuByParentId(@Param("parent_id") int parentId) throws SQLException;
}

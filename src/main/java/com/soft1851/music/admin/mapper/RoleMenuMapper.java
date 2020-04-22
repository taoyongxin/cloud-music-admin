package com.soft1851.music.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft1851.music.admin.entity.RoleMenu;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tao
 * @since 2020-04-21
 */
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {

    /**
     * 根据角色id查出权限菜单的顶级菜单
     * @param roleId
     * @return
     * @throws SQLException
     */
    @Results({
            @Result(property = "subMenus",column = "id",
                    many = @Many(select = "com.soft1851.music.admin.mapper.SysMenuMapper.getMenuByParentId")
            )
    })
    @Select("SELECT t1.id,t1.parent_id,t1.title,t1.path,t1.icon,t1.status,t2.role_id,t2.menu_id,t2.permissions " +
            "FROM role_menu t2 " +
            "LEFT JOIN sys_menu t1 " +
            "ON t2.menu_id = t1.id " +
            "WHERE t2.role_id = #{roleId} AND t1.parent_id = 0 ORDER BY t1.sort ")
    List<Map> getParentMenuByRoleId(int roleId) throws SQLException;

}

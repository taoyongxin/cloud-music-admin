package com.soft1851.music.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft1851.music.admin.entity.SysAdmin;
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
public interface SysAdminMapper extends BaseMapper<SysAdmin> {

//    /**
//     * 通过帐号查找用户
//     * @param name
//     * @return
//     * @throws SQLException
//     */
//    @Select("SELECT * FROM sys_admin WHERE name=#{name}")
//    SysAdmin getSysAdminByName(@Param("name") String name) throws SQLException;

    /**
     * 根据用户id查询角色信息
     * @param adminId
     * @return
     * @throws SQLException
     */
    List<SysAdmin> getAdminMenuByAdminId(String adminId) throws SQLException;

    /**
     * 根据用户name查询用户角色信息
     * @param name
     * @return
     * @throws SQLException
     */
    @Select("SELECT t1.id,t1.name,t1.avatar,t1.create_time,t2.role_name,t2.role_id " +
            "FROM role_admin t3 " +
            "LEFT JOIN sys_admin t1 " +
            "ON t3.admin_id = t1.id " +
            "LEFT JOIN sys_role t2 " +
            "ON t3.role_id = t2.role_id " +
            "WHERE t3.name = #{name}")
    List<Map> getRoleByName(String name) throws SQLException;

}

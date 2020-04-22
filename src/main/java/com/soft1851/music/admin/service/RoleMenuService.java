package com.soft1851.music.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.entity.RoleMenu;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tao
 * @since 2020-04-21
 */
public interface RoleMenuService extends IService<RoleMenu> {
    /**
     * 通过用户name查询权限菜单
     * @param name
     * @return
     */
//    List<Map> getMenusByName(String name);
    ResponseResult getMenusByName(String name);

    /**
     * 根据角色id查出菜单
     * @param roleId
     * @return
     */
    ResponseResult getParentMenuByRoleId(int roleId);
}

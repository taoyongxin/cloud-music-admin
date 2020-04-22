package com.soft1851.music.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.dto.LoginDto;
import com.soft1851.music.admin.entity.SysAdmin;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tao
 * @since 2020-04-21
 */
public interface SysAdminService extends IService<SysAdmin> {
    /**
     * 登录
     * @param loginDto
     * @return
     */
    boolean login(LoginDto loginDto);

    /**
     * 根据name查询Admin
     * @param name
     * @return
     */
    SysAdmin getAdmin(String name);

    /**
     * 根据帐号查出角色身份
     * @param name
     * @return
     */
    ResponseResult getRoleByName(String name);

    /**
     * 根据用户id查询用户信息及角色信息
     * @param userId
     * @return
     */
    List<SysAdmin> getAdminMenuByAdminId(String userId);
}

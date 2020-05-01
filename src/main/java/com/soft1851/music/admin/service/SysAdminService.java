package com.soft1851.music.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.domain.dto.LoginDto;
import com.soft1851.music.admin.domain.entity.SysAdmin;
import org.springframework.validation.annotation.Validated;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tao
 * @since 2020-04-21
 */
@Validated
public interface SysAdminService extends IService<SysAdmin> {
    /**
     * 登录
     * @param loginDto
     * @return
     */
    Map<String,Object> login(LoginDto loginDto);

    /**
     * 根据name查询Admin信息，包含其所有角色
     * @param name
     * @return
     */
    SysAdmin getAdminRolesByName(String name);

    /**
     * 修改个人信息数据
     * @param sysAdmin
     * @return
     */
    ResponseResult updateSysAdmin(SysAdmin sysAdmin);
}

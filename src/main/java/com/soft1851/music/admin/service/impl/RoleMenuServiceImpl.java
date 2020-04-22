package com.soft1851.music.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.common.ResultCode;
import com.soft1851.music.admin.entity.RoleMenu;
import com.soft1851.music.admin.exception.CustomException;
import com.soft1851.music.admin.mapper.RoleMenuMapper;
import com.soft1851.music.admin.mapper.SysAdminMapper;
import com.soft1851.music.admin.service.RoleMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tao
 * @since 2020-04-21
 */
@Service
@Slf4j
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {
    @Resource
    private RoleMenuMapper roleMenuMapper;
    @Resource
    private SysAdminMapper sysAdminMapper;

    @Override
    public ResponseResult getMenusByName(String name) {
        List<Map> roleMapList;
        List<Map> map = null;
        try {
            roleMapList = sysAdminMapper.getRoleByName(name);
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new CustomException("数据库出错", ResultCode.DATABASE_ERROR);
        }
        for(Map role:roleMapList){
            try {
                map = roleMenuMapper.getParentMenuByRoleId((Integer) role.get("role_id"));
                role.put("Menus",map);
            } catch (SQLException e) {
                log.error(e.getMessage());
                throw new CustomException("数据库出错", ResultCode.DATABASE_ERROR);
            }
        }
        return ResponseResult.success(roleMapList);
    }

    @Override
    public ResponseResult getParentMenuByRoleId(int roleId) {
        List<Map> mapList = null;
        try {
            mapList = roleMenuMapper.getParentMenuByRoleId(roleId);
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new CustomException("数据库出错", ResultCode.DATABASE_ERROR);
        }
        return ResponseResult.success(mapList);
    }


}

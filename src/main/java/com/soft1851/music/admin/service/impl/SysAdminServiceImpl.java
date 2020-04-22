package com.soft1851.music.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.common.ResultCode;
import com.soft1851.music.admin.dto.LoginDto;
import com.soft1851.music.admin.entity.SysAdmin;
import com.soft1851.music.admin.exception.CustomException;
import com.soft1851.music.admin.mapper.SysAdminMapper;
import com.soft1851.music.admin.service.SysAdminService;
import com.soft1851.music.admin.util.Md5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.HashMap;
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
public class SysAdminServiceImpl extends ServiceImpl<SysAdminMapper, SysAdmin> implements SysAdminService {
    @Resource
    private SysAdminMapper sysAdminMapper;

    @Override
    public boolean login(LoginDto loginDto) {
        SysAdmin admin1 = getAdmin(loginDto.getName());
        if (admin1 != null) {
            String pass = Md5Util.getMd5(loginDto.getPassword(), true, 32);
            if (admin1.getPassword().equals(pass)) {
                return true;
            } else {
                log.error("密码错误");
                return false;
//                throw new CustomException("密码错误", ResultCode.USER_PASSWORD_ERROR);
            }
        } else {
            log.error("用户名不存在");
            return false;
//            throw new CustomException("用户名不存在", ResultCode.USER_NOT_FOUND);
        }
    }

    @Override
    public SysAdmin getAdmin(String name) {
        Map<String, Object> params = new HashMap<>(8);
        params.put("name", name);
        List<SysAdmin> admins = sysAdminMapper.selectByMap(params);
        if (admins.size() > 0) {
            return sysAdminMapper.selectByMap(params).get(0);
        } else {
            return null;
        }
    }

    @Override
    public ResponseResult getRoleByName(String name) {
        List<Map> mapList = null;
        try {
            mapList = sysAdminMapper.getRoleByName(name);
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new CustomException("数据库出错", ResultCode.DATABASE_ERROR);
        }
        return ResponseResult.success(mapList);
    }

    @Override
    public List<SysAdmin> getAdminMenuByAdminId(String userId) {
        return null;
    }


}

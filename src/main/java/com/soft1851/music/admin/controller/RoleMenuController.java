package com.soft1851.music.admin.controller;


import com.soft1851.music.admin.common.ResponseResult;
import com.soft1851.music.admin.service.RoleMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author tao
 * @since 2020-04-21
 */
@RestController
@Slf4j
@RequestMapping("/roleMenu")
public class RoleMenuController {
    @Resource
    private RoleMenuService roleMenuService;

    //    @GetMapping()
//    public ResponseResult getMenusByName(@Param("name") String name){
//        return roleMenuService.getMenusByName(name);
//    }
    @GetMapping(value = "/all/{name}")
    public ResponseResult getMenusByName(@PathVariable String name) {
        return roleMenuService.getMenusByName(name);
    }

    @GetMapping(value = "/{roleId}")
    public ResponseResult getParentMenuByRoleId(@PathVariable int roleId) {
        return roleMenuService.getParentMenuByRoleId(roleId);
    }
}

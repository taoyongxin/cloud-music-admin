package com.soft1851.music.admin.mapper;

import com.soft1851.music.admin.CloudMusicAdminApplication;
import com.soft1851.music.admin.domain.entity.SysMenu;
import com.soft1851.music.admin.domain.entity.SysRole;
import com.soft1851.music.admin.util.TreeBuilder;
import com.soft1851.music.admin.util.TreeNode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = CloudMusicAdminApplication.class)
class SysRoleMapperTest {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Test
    void selectRoleById() throws SQLException {
        SysRole sysRole = sysRoleMapper.selectRoleById(1);
//        System.out.println(sysRole.getRoleName());
        List<SysMenu> menus = sysRole.getMenus();
        menus.forEach(System.out::println);
        System.out.println("*********************************");
//      将扁平化的菜单数据  转换成树形结构
        List<TreeNode> list = new ArrayList<>();
        for (SysMenu menu :menus){
            if (menu.getParentId() == 0){
                TreeNode treeNode = new TreeNode(
                        menu.getId(), 0,
                        menu.getType(),
                        menu.getTitle(),
                        menu.getIcon(),
                        menu.getPath(),
                        menu.getSort(),
                        menu.getStatus());
                list.add(treeNode);
            } else {
                TreeNode treeNode = new TreeNode(
                        menu.getId(),
                        menu.getParentId(),
                        menu.getType(),
                        menu.getTitle(),
                        menu.getIcon(),
                        menu.getPath(),
                        menu.getSort(),
                        menu.getStatus());
                list.add(treeNode);
            }
        }
        List<TreeNode> trees = TreeBuilder.buildTreeByLoop(list);
        System.out.println(trees);
    }
}
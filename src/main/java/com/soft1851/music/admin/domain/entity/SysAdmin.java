package com.soft1851.music.admin.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author tao
 * @since 2020-04-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_admin")
public class SysAdmin extends Model<SysAdmin> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("id")
    private String id;

    /**
     * 用户名
     */
    @Size(max = 15,message = "用户名长度在15以内")
    private String name;

    /**
     * 密码
     */

    @TableField("password")
    private String password;

    /**
     * 加密盐
     */
    @JsonIgnore
    @TableField("salt")
    private String salt;

    /**
     * 头像
     */
    @URL(message = "头像不是链接的形式")
    @TableField("avatar")
    private String avatar;

    /**
     * 创建时间
     */
    @JsonIgnore
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @JsonIgnore
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 账户状态：0 禁用 1 启用
     */
    @JsonIgnore
    @TableField("status")
    private Integer status;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    /**
     * SysAdmin中增加一个SysRole的List
     */
    private List<SysRole> roles;
}

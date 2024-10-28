package com.qianting.yoga.studio.domian.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户表，存储系统中的用户信息(User)表实体类
 *
 * @author makejava
 * @since 2024-10-27 19:37:16
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {

    //用户ID
    @TableId
    private Integer userId;

    //用户名
    private String username;
    //密码
    private String password;
    //手机号码
    private String phone;
    //性别（M：男，F：女）
    private String gender;
    //用户头像URL
    private String avatar;
    //身份类型（如：管理员为0、老师为1、学生为2）
    private Integer identity;
    //用户创建时间
    private Date createTime;
    //用户信息更新时间
    private Date updateTime;
    //删除标识（0：未删除，1：已删除）
    private Integer delFlag;
}


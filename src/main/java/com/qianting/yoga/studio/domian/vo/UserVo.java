package com.qianting.yoga.studio.domian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Me
 * @version 1.0
 * @date 2024/10/27 20:11
 * @Description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    //用户ID
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
}

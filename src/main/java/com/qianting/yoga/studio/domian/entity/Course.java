package com.qianting.yoga.studio.domian.entity;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 课程表，存储用户可以学习的课程信息(Course)表实体类
 *
 * @author makejava
 * @since 2024-11-05 10:52:07
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("course")
public class Course {

    //课程ID
    @TableId
    private Integer courseId;

    //课程名称
    private String courseName;
    //课程内容
    private String courseContent;
    //课程类别
    private String category;
    //课程创建时间
    private Date createTime;
    //课程更新时间
    private Date updateTime;
    //删除标识（0：未删除，1：已删除）
    private Integer delFlag;
}


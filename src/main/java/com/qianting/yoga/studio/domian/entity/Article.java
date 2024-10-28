package com.qianting.yoga.studio.domian.entity;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 文章表，存储用户发布的文章(Article)表实体类
 *
 * @author makejava
 * @since 2024-10-27 19:35:45
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("article")
public class Article {

    //文章ID
    @TableId
    private Integer articleId;

    //文章标题
    private String title;
    //文章内容
    private String content;
    //创建文章的用户ID
    private Integer createUserId;
    //文章类型
    private String category;
    //文章配图URL
    private String image;
    //文章创建时间
    private Date createTime;
    //文章更新时间
    private Date updateTime;
    //删除标识（0：未删除，1：已删除）
    private Integer delFlag;
    //浏览量
    private Integer views;
}


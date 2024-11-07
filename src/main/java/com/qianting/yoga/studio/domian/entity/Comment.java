package com.qianting.yoga.studio.domian.entity;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 评论表，存储用户对文章的评论(Comment)表实体类
 *
 * @author makejava
 * @since 2024-11-07 21:54:10
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("comment")
public class Comment {

    //评论ID
    @TableId
    private Integer commentId;

    //评论关联的文章ID
    private Integer articleId;
    //评论用户ID
    private Integer commentUserId;
    //文章配图URL
    private String image;
    //评论内容
    private String content;
    //评论创建时间
    private Date createTime;
    //评论更新时间
    private Date updateTime;
    //删除标识（0：未删除，1：已删除）
    private Integer delFlag;
}


package com.qianting.yoga.studio.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qianting.yoga.studio.domian.entity.Comment;
import com.qianting.yoga.studio.domian.entity.ResponseResult;

/**
 * 评论表，存储用户对文章的评论(Comment)表服务接口
 *
 * @author makejava
 * @since 2024-11-07 21:54:11
 */
public interface CommentService extends IService<Comment> {
    ResponseResult commentListInformation();

    ResponseResult updataComment(Comment comment);

    ResponseResult deleteComment(Comment comment);
}

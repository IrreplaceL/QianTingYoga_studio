package com.qianting.yoga.studio.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianting.yoga.studio.domian.entity.Comment;
import com.qianting.yoga.studio.domian.entity.Course;
import com.qianting.yoga.studio.domian.entity.ResponseResult;
import com.qianting.yoga.studio.mapper.CommentMapper;
import com.qianting.yoga.studio.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 评论表，存储用户对文章的评论(Comment)表服务实现类
 *
 * @author makejava
 * @since 2024-11-07 21:54:11
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public ResponseResult commentListInformation() {
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        //按照用户id升序排列
        queryWrapper.orderByAsc(Comment::getCommentId);
        Page<Comment> page = new Page(1,10);
        page(page,queryWrapper);
        //封装响应
        List<Comment> courses = page.getRecords();
        //利用工具类
        return ResponseResult.successResult(courses);
    }

    @Override
    public ResponseResult updataComment(Comment comment) {
        if(comment.getCommentId() == null){
            comment.setCreateTime(new Date());
            comment.setUpdateTime(new Date());
            save(comment);
        }else {
            updateById(comment);
            comment.setUpdateTime(new Date());
        }
        return ResponseResult.successResult();
    }

    @Override
    public ResponseResult deleteComment(Comment comment) {
       commentMapper.deleteById(comment.getCommentUserId());
       return ResponseResult.successResult();
    }
}

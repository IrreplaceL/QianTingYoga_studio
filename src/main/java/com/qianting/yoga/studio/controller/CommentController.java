package com.qianting.yoga.studio.controller;

import com.qianting.yoga.studio.domian.entity.Comment;
import com.qianting.yoga.studio.domian.entity.Course;
import com.qianting.yoga.studio.domian.entity.ResponseResult;
import com.qianting.yoga.studio.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 评论表
 * @author Me
 * @version 1.0
 * @date 2024/11/7 21:57
 * @Description:评论表的接口
 */

@RestController
@RequestMapping("/comment")
@Slf4j
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 获取所有评论信息
     * @return
     */
    @GetMapping("/commentListInformation")
    public ResponseResult commentListInformation(){
        return commentService.commentListInformation();
    }

    /**
     * 更新评论表信息
     * @param comment
     * @return
     */
    @PostMapping("/updataComment")
    public ResponseResult updataComment(@RequestBody Comment comment){
        return commentService.updataComment(comment);
    }

    /**
     * 删除评论表
     * @param comment
     * @return
     */
    @PostMapping("/deleteCommnet")
    public ResponseResult deleteCourse(@RequestBody Comment comment){
        return commentService.deleteComment(comment);
    }

}

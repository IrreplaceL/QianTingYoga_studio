package com.qianting.yoga.studio.controller;

import com.qianting.yoga.studio.domian.entity.ResponseResult;
import com.qianting.yoga.studio.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 课程表
 * @author Me
 * @version 1.0
 * @date 2024/11/5 10:57
 * @Description:课程表相关信息
 */


@RestController
@RequestMapping("/course")
@Slf4j
public class CourseController {
    @Autowired
    private CourseService courseService;

    /**
     * 获取所有课程信息
     * @return
     */
    @GetMapping("/courseInformationList")
    public ResponseResult courseListInformation(){
        return courseService.courseListInformation();
    }
}

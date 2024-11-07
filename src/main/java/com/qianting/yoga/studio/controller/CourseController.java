package com.qianting.yoga.studio.controller;

import com.qianting.yoga.studio.domian.entity.Course;
import com.qianting.yoga.studio.domian.entity.ResponseResult;
import com.qianting.yoga.studio.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 对课程表进行更新或新增操作
     * @param course 不传id为新增，传id为新增。（只需传入courseId（新增时），courseName，courseContent，category）
     * @return
     */
    @PostMapping("/updataCourse")
    public ResponseResult updataCourse(@RequestBody Course course){
        return courseService.updataCourse(course);
    }

    /**
     * 对课程表进行删除
     * @param course
     * @return
     */
    @PostMapping("/deleteCourse")
    public ResponseResult deleteCourse(@RequestBody Course course){
        return courseService.deleteCourse(course);
    }
}

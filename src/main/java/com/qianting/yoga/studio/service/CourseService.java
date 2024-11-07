package com.qianting.yoga.studio.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qianting.yoga.studio.domian.entity.Course;
import com.qianting.yoga.studio.domian.entity.ResponseResult;

/**
 * 课程表，存储用户可以学习的课程信息(Course)表服务接口
 *
 * @author makejava
 * @since 2024-11-05 10:52:07
 */
public interface CourseService extends IService<Course> {
    ResponseResult courseListInformation();

    ResponseResult updataCourse(Course course);

    ResponseResult deleteCourse(Course course);
}

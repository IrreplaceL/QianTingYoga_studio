package com.qianting.yoga.studio.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianting.yoga.studio.domian.entity.Article;
import com.qianting.yoga.studio.domian.entity.Course;
import com.qianting.yoga.studio.domian.entity.ResponseResult;
import com.qianting.yoga.studio.mapper.CourseMapper;
import com.qianting.yoga.studio.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 课程表，存储用户可以学习的课程信息(Course)表服务实现类
 *
 * @author makejava
 * @since 2024-11-05 10:52:07
 */
@Service("courseService")
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    private CourseMapper courseMapper;
    @Override
    public ResponseResult courseListInformation() {
        LambdaQueryWrapper<Course> queryWrapper = new LambdaQueryWrapper<>();
        //按照用户id升序排列
        queryWrapper.orderByAsc(Course::getCourseId);
        Page<Course> page = new Page(1,10);
        page(page,queryWrapper);
        //封装响应
        List<Course> courses = page.getRecords();
        //利用工具类
        return ResponseResult.successResult(courses);

    }

    @Override
    public ResponseResult updataCourse(Course course) {
        if(course.getCourseId() == null){
            course.setCreateTime(new Date());
            course.setUpdateTime(new Date());
        save(course);
        }else {
        updateById(course);
        course.setUpdateTime(new Date());
    }
        return ResponseResult.successResult();}

    @Override
    public ResponseResult deleteCourse(Course course) {
       courseMapper.deleteById(course.getCourseId());
       return ResponseResult.successResult();
    }
}

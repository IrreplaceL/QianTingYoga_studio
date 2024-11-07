package com.qianting.yoga.studio.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qianting.yoga.studio.domian.entity.Article;
import com.qianting.yoga.studio.domian.entity.Course;
import com.qianting.yoga.studio.domian.entity.ResponseResult;

/**
 * 文章表，存储用户发布的文章(Article)表服务接口
 *
 * @author makejava
 * @since 2024-11-05 08:34:17
 */
public interface ArticleService extends IService<Article> {
    ResponseResult articleListInformation();

    ResponseResult articleUpdata(Article article);

    ResponseResult deleteCourse(Article article);
}

package com.qianting.yoga.studio.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianting.yoga.studio.domian.entity.Article;
import com.qianting.yoga.studio.domian.entity.Course;
import com.qianting.yoga.studio.domian.entity.ResponseResult;
import com.qianting.yoga.studio.mapper.ArticleMapper;
import com.qianting.yoga.studio.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

/**
 * 文章表，存储用户发布的文章(Article)表服务实现类
 *
 * @author makejava
 * @since 2024-11-05 08:34:17
 */
@Service("articleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public ResponseResult articleListInformation() {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //按照用户id升序排列
        queryWrapper.orderByAsc(Article::getArticleId);
        Page<Article> page = new Page(1,10);
        page(page,queryWrapper);
        //封装响应
        List<Article> articles = page.getRecords();
        //利用工具类
        return ResponseResult.successResult(articles);

    }

    @Override
    public ResponseResult articleUpdata(Article article) {
        if(article.getArticleId() == null){
            article.setCreateTime(new Date());
            article.setUpdateTime(new Date());
            save(article);
        }else {
            updateById(article);
            article.setUpdateTime(new Date());
        }
        return ResponseResult.successResult();
    }

    @Override
    public ResponseResult deleteCourse( Article article) {
        articleMapper.deleteById(articleMapper.deleteById(article.getArticleId()));
        return ResponseResult.successResult();
    }
}

package com.qianting.yoga.studio.controller;

import com.qianting.yoga.studio.domian.entity.Article;
import com.qianting.yoga.studio.domian.entity.Course;
import com.qianting.yoga.studio.domian.entity.ResponseResult;
import com.qianting.yoga.studio.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 文章
 * @author Me
 * @version 1.0
 * @date 2024/11/5 8:42
 * @Description:文章表：包含文章访问的接口
 */

@RestController
@RequestMapping("/article")
@Slf4j
public class ArticleController {
   @Autowired
   private ArticleService articleService;

    /**
     * 获取所有文章列表所有文章
     * @return
     */
   @GetMapping("/articleInformationList")
   public ResponseResult articleListInformation(){
      return articleService. articleListInformation();
   }

    /**
     * 更新文章，（新增和更改，id設置參考課程表，注意    "createUserId": 1,應該為用戶表主鍵，已在數據庫設置外鍵關聯，用戶表沒有該id將更新失敗，    更新操作時，"articleId": 3,應爲存在數據庫中文章表的主鍵，否則更新失敗）
     * @param article
     * @return
     */
   @PostMapping("/articleUpdata")
    public ResponseResult articleUpdata(@RequestBody Article article){
       return articleService.articleUpdata(article);
   }

    /**
     * 对课程表的删除（del_flag）
     * @param article
     * @return
     */
    @PostMapping("/deleteArticle")
    public ResponseResult deleteAticle(@RequestBody Article article){
        return articleService.deleteCourse(article);
    }
}

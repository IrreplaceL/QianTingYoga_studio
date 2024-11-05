package com.qianting.yoga.studio.controller;

import com.qianting.yoga.studio.domian.entity.ResponseResult;
import com.qianting.yoga.studio.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
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

   @GetMapping("/userInformationList")
   public ResponseResult articlerListInformation(){
      return articleService. articlerListInformation();
   }
}
